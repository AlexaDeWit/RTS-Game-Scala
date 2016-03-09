lazy val commonSettings = Seq(
  version := "0.01",
  scalaVersion := "2.11.7"
)

lazy val userName = sys.props.getOrElse("USER", default = "alexandra")

lazy val root = (project in file(".")).
settings( commonSettings: _* ).
settings(
  name := "RTSGame",
  fork in run := true,
  javaOptions in run += f"-Djava.library.path=${baseDirectory.value}%s/native",
  libraryDependencies ++= Seq(
    "io.argonaut" %% "argonaut" % "6.1",
    "org.scalaz" %% "scalaz-core" % "7.1.1"
  )

)
