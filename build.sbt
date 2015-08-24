val appDependencies = Seq(
    javaCore,
    javaJpa,
    "org.springframework" % "spring-context" % "4.1.6.RELEASE",
    "javax.inject" % "javax.inject" % "1",
    "org.springframework.data" % "spring-data-jpa" % "1.8.0.RELEASE",
    "org.springframework" % "spring-expression" % "4.1.6.RELEASE",
    "org.hibernate" % "hibernate-entitymanager" % "4.3.10.Final",
    "org.mockito" % "mockito-core" % "1.9.5" % "test",
	"mysql" % "mysql-connector-java" % "5.1.18",
	"be.objectify"  %% "deadbolt-java"     % "2.4.0",
	"com.feth"      %% "play-authenticate" % "0.7.0-SNAPSHOT"
)

lazy val commonSettings = Seq(
	version := "0.1.0",
	scalaVersion := "2.11.6"
)

resolvers += Resolver.sonatypeRepo("snapshots")

lazy val root = project.in(file("."))
  .enablePlugins(PlayJava)
  .settings(commonSettings: _*)
  .settings(
	name := "play-spring-data-jpa",
    libraryDependencies ++= appDependencies
  )