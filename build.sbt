val catsVersion           = "2.9.0"
val catsEffectVersion     = "3.4.2"
val fs2Version            = "3.4.0"
val scodecBitsVersion     = "1.1.34"
val scodecCoreVersion     = "2.2.0"
val specs2Version         = "4.17.0"
val tikaVersion           = "1.24"
val scalacheckVersion     = "1.15.4"
val log4catsVersion       = "2.1.1"
val logbackVersion        = "1.2.3"


lazy val root = (project in file("."))
  .settings(
    organization := "com.minosiants",
    name := "pencil",
    scalaVersion := "3.2.1",
    crossScalaVersions := Seq(scalaVersion.value),
    scalacOptions ++= Seq(
       "-language:implicitConversions",
       "-Ykind-projector",
       "-source:3.0-migration"
    ),
    libraryDependencies ++= Seq(
      "org.typelevel"   %% "cats-core"         % catsVersion,
      "org.typelevel"   %% "cats-effect"       % catsEffectVersion,
      "co.fs2"          %% "fs2-core"          % fs2Version,
      "co.fs2"          %% "fs2-scodec"        % fs2Version,
      "co.fs2"          %% "fs2-io"            % fs2Version,
      "org.scodec"      %% "scodec-bits"       % scodecBitsVersion,
      "org.scodec"      %% "scodec-core"       % scodecCoreVersion,
      "org.typelevel"   %% "log4cats-core"     % log4catsVersion,
      "org.apache.tika" % "tika-core"          % tikaVersion,
      "org.specs2"      %% "specs2-core"       % specs2Version % "test",
      "org.specs2"      %% "specs2-scalacheck" % specs2Version % Test,
      "org.scalacheck"  %% "scalacheck"        % scalacheckVersion % "test",
      "ch.qos.logback"  % "logback-classic"    % logbackVersion % "test",
      "org.typelevel"   %% "log4cats-slf4j"    % log4catsVersion % "test"
    ),
    publishTo := sonatypePublishToBundle.value
  )
  .settings(releaseProcessSettings)
  .settings(licenceSettings)

import ReleaseTransformations._
lazy val releaseProcessSettings = Seq(
  releaseIgnoreUntrackedFiles := true,
  releasePublishArtifactsAction := PgpKeys.publishSigned.value,
  releaseCrossBuild := true,
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    releaseStepCommandAndRemaining("+ publishSigned"),
    releaseStepCommand("sonatypeBundleRelease"),
    setNextVersion,
    commitNextVersion,
    pushChanges
  )
)

lazy val licenceSettings = Seq(
  organizationName := "Kaspar Minosiants",
  startYear := Some(2020),
  licenses += ("Apache-2.0", new URL(
    "https://www.apache.org/licenses/LICENSE-2.0.txt"
  ))
)
