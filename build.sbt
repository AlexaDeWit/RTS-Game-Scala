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
  javaOptions in run += f"-Djava.library.path=/home/$userName%s/Dropbox/Scala/RTSGame/native",
  libraryDependencies ++= Seq(
  )

)
