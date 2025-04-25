package com.github.DevSankhya;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "project", namespace = "http://maven.apache.org/POM/4.0.0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "modelVersion", "groupId", "artifactId", "version", "packaging", "name", "description"
})
public class Pom {

    @XmlElement(namespace = "http://maven.apache.org/POM/4.0.0")
    private String modelVersion;

    @XmlElement(namespace = "http://maven.apache.org/POM/4.0.0")
    private String groupId;

    @XmlElement(namespace = "http://maven.apache.org/POM/4.0.0")
    private String artifactId;

    @XmlElement(namespace = "http://maven.apache.org/POM/4.0.0")
    private String version;

    @XmlElement(namespace = "http://maven.apache.org/POM/4.0.0")
    private String packaging;

    @XmlElement(namespace = "http://maven.apache.org/POM/4.0.0")
    private String name;

    @XmlElement(namespace = "http://maven.apache.org/POM/4.0.0")
    private String description;

    // Getters e Setters obrigatórios

    public String getModelVersion() { return modelVersion; }
    public void setModelVersion(String modelVersion) { this.modelVersion = modelVersion; }

    public String getGroupId() { return groupId; }
    public void setGroupId(String groupId) { this.groupId = groupId; }

    public String getArtifactId() { return artifactId; }
    public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public String getPackaging() { return packaging; }
    public void setPackaging(String packaging) { this.packaging = packaging; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
