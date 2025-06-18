package data

import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAccessType

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
data class StudentsWrapper(
    @field:XmlElement(name = "student")
    val students: MutableList<Student> = mutableListOf()
)