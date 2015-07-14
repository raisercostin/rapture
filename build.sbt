import com.typesafe.sbt.pgp.PgpKeys.publishSigned
import sbtrelease.ReleaseStep
import sbtrelease.ReleasePlugin.ReleaseKeys.releaseProcess
import sbtrelease.ReleaseStateTransformations._
import sbtrelease.Utilities._

enablePlugins(GitBranchPrompt)

lazy val buildSettings = Seq(
  organization := "com.propensive",
  scalaVersion := "2.11.7",
  crossScalaVersions := Seq("2.11.7", "2.10.5")
)

lazy val commonSettings = Seq(
  scalacOptions ++= Seq(
 /*   "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:experimental.macros",
    "-unchecked",
    "-Xfatal-warnings",
    "-Xlint",
    "-Yinline-warnings",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Xfuture" */
  ) ++ (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11)) => Seq("-Ywarn-unused-import")
    case _             => Seq.empty
  }),
  scalacOptions in (Compile, console) ~= (_ filterNot (_ == "-Ywarn-unused-import")),
  scalacOptions in (Test, console) := (scalacOptions in (Compile, console)).value,
  scalaJSStage in Test := FastOptStage,
  scmInfo := Some(ScmInfo(url("https://github.com/propensive/rapture"),
    "scm:git:git@github.com:propensive/rapture.git")),
  commands += gitSnapshots
) ++ scalaMacroDependencies

lazy val raptureSettings = buildSettings ++ commonSettings ++ publishSettings ++ releaseSettings

lazy val rapture = project.in(file("."))
  .settings(moduleName := "root")
  .settings(raptureSettings)
  .settings(noPublishSettings)
  .settings(noSourceSettings)
  .aggregate(raptureJVM, raptureJS)
  .dependsOn(raptureJVM, raptureJS)

lazy val raptureJVM = project.in(file(".raptureJVM"))
  .settings(moduleName := "rapture")
  .settings(raptureSettings)
  .aggregate(baseJVM, coreJVM, uriJVM, codecJVM, cryptoJVM, csvJVM, ioJVM, fsJVM, netJVM, mimeJVM, cliJVM, logJVM, i18nJVM, textJVM, latexJVM, testJVM, dataJVM, jsonJVM, jsonJawnJVM)
  .dependsOn(baseJVM, coreJVM, uriJVM, codecJVM, cryptoJVM, csvJVM, ioJVM, fsJVM, netJVM, mimeJVM, cliJVM, logJVM, i18nJVM, textJVM, latexJVM, testJVM, dataJVM, jsonJVM, jsonJawnJVM)
  
lazy val raptureJS = project.in(file(".raptureJS"))
  .settings(moduleName := "rapture")
  .settings(raptureSettings)
  .aggregate(baseJS, coreJS, uriJS, codecJS, cryptoJS, csvJS, ioJS, fsJS, netJS, mimeJS, cliJS, logJS, i18nJS, textJS, latexJS, testJS, dataJS, jsonJS, jsonJawnJS)
  .dependsOn(baseJS, coreJS, uriJS, codecJS, cryptoJS, csvJS, ioJS, fsJS, netJS, mimeJS, cliJS, logJS, i18nJS, textJS, latexJS, testJS, dataJS, jsonJS, jsonJawnJS)
  .enablePlugins(ScalaJSPlugin)

// rapture-base
lazy val base = crossProject
  .settings(moduleName := "rapture-base")
  .settings(raptureSettings:_*)
  .settings(crossVersionSharedSources():_*)

lazy val baseJVM = base.jvm
lazy val baseJS = base.js

// rapture-core
lazy val core = crossProject.dependsOn(base)
  .settings(moduleName := "rapture-core")
  .settings(raptureSettings:_*)

lazy val coreJVM = core.jvm
lazy val coreJS = core.js

// rapture-uri
lazy val uri = crossProject.dependsOn(core)
  .settings(moduleName := "rapture-uri")
  .settings(raptureSettings:_*)
 
lazy val uriJVM = uri.jvm
lazy val uriJS = uri.js

// rapture-codec
lazy val codec = crossProject.dependsOn(core)
  .settings(moduleName := "rapture-codec")
  .settings(raptureSettings:_*)
 
lazy val codecJVM = codec.jvm
lazy val codecJS = codec.js

// rapture-crypto
lazy val crypto = crossProject.dependsOn(core, codec)
  .settings(moduleName := "rapture-crypto")
  .settings(raptureSettings:_*)
 
lazy val cryptoJVM = crypto.jvm
lazy val cryptoJS = crypto.js

// rapture-io
lazy val io = crossProject.dependsOn(codec, mime, uri)
  .settings(moduleName := "rapture-io")
  .settings(raptureSettings:_*)
 
lazy val ioJVM = io.jvm
lazy val ioJS = io.js

// rapture-mime
lazy val mime = crossProject.dependsOn()
  .settings(moduleName := "rapture-mime")
  .settings(raptureSettings:_*)
 
lazy val mimeJVM = mime.jvm
lazy val mimeJS = mime.js

// rapture-net
lazy val net = crossProject.dependsOn(io)
  .settings(moduleName := "rapture-net")
  .settings(raptureSettings:_*)
  .settings(libraryDependencies ++= Seq("commons-net" % "commons-net" % "2.0"))
 
lazy val netJVM = net.jvm
lazy val netJS = net.js

// rapture-fs
lazy val fs = crossProject.dependsOn(io)
  .settings(moduleName := "rapture-fs")
  .settings(raptureSettings:_*)
 
lazy val fsJVM = fs.jvm
lazy val fsJS = fs.js

// rapture-csv
lazy val csv = crossProject.dependsOn(fs)
  .settings(moduleName := "rapture-csv")
  .settings(raptureSettings:_*)
 
lazy val csvJVM = csv.jvm
lazy val csvJS = csv.js

// rapture-cli
lazy val cli = crossProject.dependsOn(log, fs)
  .settings(moduleName := "rapture-cli")
  .settings(raptureSettings:_*)
 
lazy val cliJVM = cli.jvm
lazy val cliJS = cli.js

// rapture-log
lazy val log = crossProject.dependsOn(io)
  .settings(moduleName := "rapture-log")
  .settings(raptureSettings:_*)
 
lazy val logJVM = log.jvm
lazy val logJS = log.js

// rapture-i18n
lazy val i18n = crossProject.dependsOn(core)
  .settings(moduleName := "rapture-i18n")
  .settings(raptureSettings:_*)
 
lazy val i18nJVM = i18n.jvm
lazy val i18nJS = i18n.js

// rapture-text
lazy val text = crossProject.dependsOn(core)
  .settings(moduleName := "rapture-text")
  .settings(raptureSettings:_*)
 
lazy val textJVM = text.jvm
lazy val textJS = text.js

// rapture-latex
lazy val latex = crossProject.dependsOn(text, cli)
  .settings(moduleName := "rapture-latex")
  .settings(raptureSettings:_*)
 
lazy val latexJVM = latex.jvm
lazy val latexJS = latex.js

// rapture-test
lazy val test = crossProject.dependsOn(cli, fs, text)
  .settings(moduleName := "rapture-test")
  .settings(raptureSettings:_*)
 
lazy val testJVM = test.jvm
lazy val testJS = test.js

// rapture-data
lazy val data = crossProject.dependsOn(core)
  .settings(moduleName := "rapture-test")
  .settings(raptureSettings:_*)
 
lazy val dataJVM = data.jvm
lazy val dataJS = data.js

// rapture-json
lazy val json = crossProject.dependsOn(data)
  .settings(moduleName := "rapture-json")
  .settings(raptureSettings:_*)
  .settings(libraryDependencies ++= Seq("org.scala-lang.modules" % "scala-parser-combinators_2.11" % "1.0.2"))
 
lazy val jsonJVM = json.jvm
lazy val jsonJS = json.js

// rapture-json-jawn
lazy val jsonJawn = crossProject.dependsOn(json)
  .settings(moduleName := "rapture-json-jawn")
  .settings(raptureSettings:_*)
  .settings(libraryDependencies ++= Seq("org.spire-math" % "jawn-parser_2.11" % "0.7.4"))
  .settings(libraryDependencies ++= Seq("org.spire-math" % "jawn-ast_2.11" % "0.7.4"))
 
lazy val jsonJawnJVM = jsonJawn.jvm
lazy val jsonJawnJS = jsonJawn.js


lazy val publishSettings = Seq(
  homepage := Some(url("http://rapture.io/")),
  licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  autoAPIMappings := true,
  publishMavenStyle := true,
  publishArtifact in packageDoc := false,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <developers>
      <developer>
        <id>propensive</id>
        <name>Jon Petty</name>
        <url>http://github.com/propensive/rapture</url>
      </developer>
    </developers>
  ),
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    publishSignedArtifacts,
    setNextVersion,
    commitNextVersion,
    pushChanges
  )
)

lazy val publishSignedArtifacts = ReleaseStep(
  action = { st =>
    val extracted = st.extract
    val ref = extracted.get(thisProjectRef)
    extracted.runAggregated(publishSigned in Global in ref, st)
  },
  check = { st =>
    // getPublishTo fails if no publish repository is set up.
    val ex = st.extract
    val ref = ex.get(thisProjectRef)
    Classpaths.getPublishTo(ex.get(publishTo in Global in ref))
    st
  },
  enableCrossBuild = true
)

lazy val noPublishSettings = Seq(
  publish := (),
  publishLocal := (),
  publishArtifact := false
)

lazy val noSourceSettings = Seq(
  sources in Compile := Seq(),
  sources in Test := Seq()
)


import java.io.File

def crossVersionSharedSources()  = Seq( 
 (unmanagedSourceDirectories in Compile) ++= { (unmanagedSourceDirectories in Compile ).value.map {
     dir:File => new File(dir.getPath + "_" + scalaBinaryVersion.value)}}
)

lazy val scalaMacroDependencies: Seq[Setting[_]] = Seq(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  libraryDependencies ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      // if scala 2.11+ is used, quasiquotes are merged into scala-reflect
      case Some((2, scalaMajor)) if scalaMajor >= 11 => Seq()
      // in Scala 2.10, quasiquotes are provided by macro paradise
      case Some((2, 10)) =>
        Seq(
          compilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full),
              "org.scalamacros" %% "quasiquotes" % "2.1.0-M5" cross CrossVersion.binary
        )
    }
  }
)

def gitSnapshots = Command.command("gitSnapshots") { state =>
  val extracted = Project extract state
  val newVersion = Seq(version in ThisBuild := git.gitDescribedVersion.value.get + "-SNAPSHOT")
  extracted.append(newVersion, state)
}

// For Travis CI - see http://www.cakesolutions.net/teamblogs/publishing-artefacts-to-oss-sonatype-nexus-using-sbt-and-travis-ci
credentials ++= (for {
  username <- Option(System.getenv().get("SONATYPE_USERNAME"))
  password <- Option(System.getenv().get("SONATYPE_PASSWORD"))
} yield Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", username, password)).toSeq