package data

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAccessType

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
data class Student(
    @field:XmlElement(name = "id")
    var id: Int = 0,

    @field:XmlElement(name = "name")
    var name: String = "",

    @field:XmlElement(name = "skills")
    var skills: Skills = Skills()
)