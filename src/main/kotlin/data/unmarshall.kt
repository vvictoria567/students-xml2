import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller
import javax.xml.bind.Unmarshaller
import data.*

fun main() {
    val inputFilePath = "students.xml"
    val outputFilePath = "updated_students.xml"

    // 1. Unmarshall XML в объекты
    val studentsWrapper = unmarshall(inputFilePath)

    // 2. Вывести текущих студентов
    studentsWrapper.students.forEach { println(it) }

    // 3. Добавить навык каждому студенту
    studentsWrapper.students.forEach { it.skills.skillList.add("New Skill") }

    // 4. Marshall обратно в XML
    marshall(studentsWrapper, outputFilePath)

    println("Обновленный файл сохранен как $outputFilePath")
}

fun unmarshall(filePath: String): StudentsWrapper {
    return try {
        val jaxbContext = JAXBContext.newInstance(StudentsWrapper::class.java)
        val unmarshaller: Unmarshaller = jaxbContext.createUnmarshaller()
        unmarshaller.unmarshal(File(filePath)) as StudentsWrapper
    } catch (e: Exception) {
        e.printStackTrace()
        StudentsWrapper()
    }
}

fun marshall(studentsWrapper: StudentsWrapper, outputPath: String) {
    try {
        val jaxbContext = JAXBContext.newInstance(StudentsWrapper::class.java)
        val marshaller: Marshaller = jaxbContext.createMarshaller()
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        marshaller.marshal(studentsWrapper, File(outputPath))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}