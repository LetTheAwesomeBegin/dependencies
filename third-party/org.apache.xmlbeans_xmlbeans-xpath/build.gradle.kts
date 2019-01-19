dependencies {
  implementation("org.apache.xmlbeans:xmlbeans-xpath:${extra["xmlbeansVersion"]}") {
    exclude(group = "net.sf.saxon", module = "saxon")
  }
}
