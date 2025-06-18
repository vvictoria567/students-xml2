package data

import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAccessType

@XmlRootElement(name = "skills")
@XmlAccessorType(XmlAccessType.FIELD)
data class Skills(
    @field:XmlElement(name = "skill")
    val skillList: MutableList<String> = mutableListOf()
)