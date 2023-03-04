// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "com.kailuowang"

// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// Open-source license of your choice
licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

// Where is the source code hosted: GitHub or GitLab?
import xerial.sbt.Sonatype._
sonatypeProjectHosting := Some(
  GitHubHosting("kailuowang", "pencil", "kailuo.wang@gmail.com")
)

developers := List(
  Developer(
    id = "minosiants",
    name = "kaspar",
    email = "k@minosiants.com",
    url = url("http://minosiants.com")
  ), Developer(
    id = "kailuowang",
    name = "kailuo wang",
    email = "kailuo.wang@gmail.com",
    url = url("http://kailuowang.com")
  )
)
