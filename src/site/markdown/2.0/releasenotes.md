# Release Notes

## Version 2.3.0 [May 11, 2016]

Improvements:

* [issue #295](https://github.com/p6spy/p6spy/issues/295): Add option to report execution time in nanoseconds or milliseconds
* [issue #313](https://github.com/p6spy/p6spy/issues/313): Remove throws SQLException declaration on P6Core.wrapConnection

Defects resolved:

* [issue #320](https://github.com/p6spy/p6spy/pull/320): Calls to getResultSet() not instrumented on Statement and PreparedStatement
* [issue #318](https://github.com/p6spy/p6spy/pull/318): Remove unused Cache abstraction and make cache thread safe
* [issue #317](https://github.com/p6spy/p6spy/pull/317): Make connectionId thread safe
* [issue #314](https://github.com/p6spy/p6spy/pull/314): ClassNotFoundException loading MySQL Statement interface using OSGi

Other:

* [issue #304](https://github.com/p6spy/p6spy/issues/304): Build failures using openjdk7
* [issue #300](https://github.com/p6spy/p6spy/issues/300): Maven warning about missing dependency

## Version 2.2.0 [March 22, 2016]

Improvements:

* [issue #290](https://github.com/p6spy/p6spy/issues/290): Lazy initialization for FileLogger

Defects resolved:

* [issue #330](https://github.com/p6spy/p6spy/issues/330): Unsafe iteration over System.getProperties() 

## Version 2.1.4 [May 9, 2015]

Defects resolved:

* [issue #286](https://github.com/p6spy/p6spy/issues/286): P6Spy proxy creation fails when JDBC object is wrapped by JBoss 7+
* [issue #282](https://github.com/p6spy/p6spy/issues/282): No resultset logged when executing a stored procedure 

## Version 2.1.3 [Jan 24, 2015]

Defects resolved:

* [issue #275](https://github.com/p6spy/p6spy/issues/275): ArrayIndexOutOfBoundsException when calling 
  PreparedStatement.setMaxRows(int) with outage module enabled 

## Version 2.1.2 [Oct 13, 2014]

Defects resolved:

* [issue #268] (https://github.com/p6spy/p6spy/issues/268): SingleLineFormat updated to remove CR and LF characters 
  from the log file 
* [issue #267] (https://github.com/p6spy/p6spy/issues/267): The equals(Object) method on all proxied objects now 
  unwraps the argument passed in (if it is a p6spy proxy) before invoking the method on the proxied object.  This 
  fixes a problem with c3p0 and statement caching.
* [issue #264] (https://github.com/p6spy/p6spy/issues/264): Fixed a defect causing the last row read of a result set 
  to not be logged unless all rows were read.

## Version 2.1.1 [Sep 9, 2014]

Defects resolved:

* [issue #256] (https://github.com/p6spy/p6spy/issues/256): jmx exposing becomes optional (enabled/disabled via flag) + jmx prefix introduced (see )
* [issue #254] (https://github.com/p6spy/p6spy/issues/254): resultset logging filtering fixed 

## Version 2.1.0 [Jun 15, 2014]

Improvements:

* P6ConnectionPoolDataSource merged to P6DataSource (to simplify datasource config)
* `excludecategories` using class `Category` rather than just plain strings (affects `P6Logger` API) 
* [issue #131](https://github.com/p6spy/p6spy/issues/131): providing additional distribution artifacts - wrapping (slf4j bridged) logging implementations for log4j, log4j2 and logback `p6spy-<version>-*-nodep.jar`
* [issue #231](https://github.com/p6spy/p6spy/issues/231): `include`/`exclude` behavior enabling any substring in SQL string matching
* considering Wrapper for DataSource proxies (bringing support for Glassfish XADataSources)
* `unSet*` API provided for properties (in `com.p6spy.engine.spy.P6SpyOptions` and `com.p6spy.engine.logging.P6LogOptions`) to enable reverting to `null` (default value) 
* [issue #247](https://github.com/p6spy/p6spy/issues/247): `-` prefixed syntax for list-like properties deprecated, in favor of full overriding

Defects resolved: 

* [issue #221] (https://github.com/p6spy/p6spy/issues/221): Bind variables set by name on a CallableStatement are now logged
* [issue #226](https://github.com/p6spy/p6spy/issues/226): `setAppender()` considered in logging properly 
* [issue #227] (https://github.com/p6spy/p6spy/issues/227): fixed disabling modules on reload
* [issue #242](https://github.com/p6spy/p6spy/issues/242): character `'` escaping in the logged SQL query fixed 
* [issue #246](https://github.com/p6spy/p6spy/issues/246): `NullPointerException` fixed for empty batch execution

## Version 2.0.2 [Apr 3, 2014]

Improvements:

* [issue #84] (https://github.com/p6spy/p6spy/issues/84): significant performance improvements for huge data selects

Defects resolved: 

* [issue #214] (https://github.com/p6spy/p6spy/issues/214): fixed PostgreSQL issue: `operator is not unique: date + unknown` 
* [issue #219](https://github.com/p6spy/p6spy/issues/219): fixed defect causing ClassCastException when setting bind variables by name on CallableStatement
* [issue #217](https://github.com/p6spy/p6spy/issues/217): fixed defect in P6Leak module causing closed connections not to be recorded properly

## Version 2.0.1 [Mar 15, 2014]

Defects resolved: 

* [issue #200] (https://github.com/p6spy/p6spy/issues/200): fixed usage with signed jdbc jars
* [issue #201] (https://github.com/p6spy/p6spy/issues/201): internal logs not printed out any more

## Version 2.0.0 [Mar 3, 2014]

Improvements:

* project hosting was moved from [sourceforge](http://sourceforge.net/projects/p6spy/) to [github](https://github.com/p6spy/p6spy)
* major part of the legacy code was refactored
* Java 6/7 JDBC API support introduced,
* proxying via modified `JDBC` `URL`s only was implemented, so for for MySQL original url would be (without a need for any further configuration):

    ```
    jdbc:mysql://<hostname>:<port>/<database>
    ```
        
    the one proxied via p6spy would one:
    
    ```
    jdbc:p6spy:mysql://<hostname>:<port>/<database>
    ```
  
 * XA Datasource support has been introduced
 * configuration via:
     * system/environment properties and
     * JMX properties
     * as an alternative to file configuration only
     * or even zero config use case supported
 * slf4j support (more flexible as previously used log4j)
 * junit tests were migrated to junit 4
 * Continuous integration using Travis was setup providing testing on popular:
     * DB systems (namely: Oracle, DB2, PostgreSQL, MySQL, H2, HSQLDB, SQLite, Firebird, and Derby), see build status on: [travis-ci](https://travis-ci.org/p6spy/p6spy) as well as 
     * application servers (namely: Wildfly 8, JBoss 4.2, 5.1, 6.1, 7.1, Glassfish 3.1, 4.0, Jetty 7.6, 8.1, 9.1, Tomcat 6, 7, 8, Resin 4, Jonas 5.3 and Geronimo 2.1, 2.2), see build status on: [travis-ci](https://travis-ci.org/p6spy/p6spy-it).

## Version 1.3 [Dec 27, 2005]

* release notes not provided

## Version 1.2

* Driver initialization bug fix and package import cleanup contributed by Joe Fisher (Joe Fisher)
* Further changes to better support JDK 1.2
* Changed a DataSource class name to avoid conflict with an Oracle class of the same name (Alan Arvesen of IronGrid)
* Allow unlimited SQL parameters (Bradley Johnson of IronGrid)

## Version 1.1

* Added a highly requested feature contributed by Jeff Wolfe that only logs queries taking longer than a specified threshold. (Jeff Wolfe)
* Added a bug fix that prevented modified property files from being persisted in Java environments prior to 1.4. (Jeff Wolfe)
* Added JBoss 2.x JMX support, submitted by Ralph Harnden (Ralph Harnden)
* Alan Arvesen of IronGrid added a driver patch that deregisters realdrivers using the same name as the P6 driver to avoid driver order registration problems (Alan Arvesen)

## Version 1.0.1

* Added a bug fix to prevent a NullPointerException from being thrown when there is a space before or after the name of the realdriver. (Paolo De Carlo)

## Version 1.0 Production Release

* In beta for over 6 months, P6Spy version 1.0 is a major rewrite of the P6Spy code. This release includes numerous new features, such as support for JDK 1.4, Datasources, log4j, JBoss 3.x, and WebSphere, as well as an overhauled, optimized architecture.

## Version 1.0 beta 9

* Added full support for DataSources and created installation instructions for WebSphere 4.0. (Dennis Parker, IronGrid)

## Version 1.0 beta 8

* Refactored options to support easier creation of new option files and clearer separation of file management from management of the actual properties.
* Reduced deployment JAR file size by 25%.
* P6Spy Documentation was overhauled. (Suzanne Patton)

## Version 1.0 beta 7

* Created code to enable more robust property file loading, including the ability to use the ClassLoader to load the property file. (Scott Howlett)
* Fixed a problem dealing with the log file being ignored.

## Version 1.0 beta 6

* Debugged and fixed a problem in which applications calling newInstance(), instead of using DriverManager, were causing the driver to load improperly.

## Version 1.0 beta 5

* Refactored the driver loading to first attempt the new classloader mechanism (implemented in Version 1 beta 2) and, upon failure, attempt the previously-used Name loading call. (Alan Arvesen, IronGrid)
* P6SpyDriver now throws an exception immediately when realdriver fails to load, making diagnostics easier.

## Version 1.0 beta 4

* Added error category and pushed error logging through the standard logging process instead of stderr. This should make it easier to diagnose problems when installation does not proceed as expected.

## Version 1.0 beta 3

* Added a call to each P6 class called getJDBC() that returns the native driver. This enables a workaround for using non-standard JDBC calls included with some JDBC drivers. See Known Issues for more information. Thanks to Ralph Harnden for the suggestion. (Alan Arvesen, IronGrid)
* Added an appender architecture which supports customizable logging. (Alan Arvesen, IronGrid)
* Changed the reloading code to work as a separate thread, making it more efficient. (Alan Arvesen, IronGrid)
* Enhanced module support, making it easier to create a new module. Now, the only required files for a new module are the factory, the driver, and the classes that are changing. If you want to intercept the Statement class only, that is the only class you need to create. In the past, you had to create an instance of every class, even if you did not want to override that class. The code to support driver loading has also been simplified.
* Added JDK 1.4 support. (Matthew Wakeling)

## Version 1.0 beta 1 & 2

* Added log4j support, which is one of the most requested feature enhancements. (Rafael Alvarez)
* Due to problems reported with driver loading in the alpha version, driver loading has been rewritten. It is now more efficient.

## Version 1.0 alpha

* Restructured code to inherit from a single core wrapper driver.
* Introduced concepts of modules and stackable drivers that dynamically load the necessary code into memory at runtime.
* Broke code into logical modules: P6Log and P6Outage.
* Refactored large amount of code.
* Rewrote JUnit tests and added more rigorous tests.

## Version 0.8

* Created an Outage Detection module that reports database outages when database statements do not respond within a given period of time. (Peter Laird)
* Created a JSP application that gives a visual control to P6Spy. The first version can be used to view configuration information about P6Spy and to create a demarcation in the log file. (Peter Laird)
* Added support for multiple simultaneous databases, a highly requested feature. Currently, support is limited to three databases, but can easily be expanded. (Viktor Szathmary)
* Added the logging of a connection ID, and enabled URLs to be prefixed with p6spy: to aid in debugging. A common mistake people make when installing is to have the real driver registered elsewhere; this feature avoids that problem. The default does not require this value, but in the future it may be mandatory to ease the install process.
* Rewrote P6SpyOptions to allow new options to be added quickly and easily.
* Additional JUnit tests added.

## Version 0.72

* Added the ability to dynamically reload the property file after a specified period of time. (Philip Ogren)
* Added logging to commit and rollback statements.

## Version 0.71

* Added installation instructions for BEA WebLogic Portal and Server. (Philip Ogren)
* Added Jakarta RegExp support. (Philip Ogren)
* Ability to print stack trace of logged statements. This is useful in understanding where a logged query is being executed in the application. (Philip Ogren)
* Simplified table monitoring property file option. (Philip Ogren)
* Updated the RegExp documentation.

## Version 0.7

* Added timing information to the log files, in order to better visualize bottleneck queries. (Simon Sadedin)
* Added RegExp support for table filtering, allowing sophisticated custom filtering. (Simon Sadedin)
* Added installation instructions for Sun iPlanet. (Michael Sgroi)
* Added installation instructions for BEA WebLogic. (Richard Delbert)
* Added support for callable statements.
* Added support for batch statements.
* Added a debug category that provides detailed debug information. By default, this is disabled. Refer to the Troubleshooting section for more information.
* Changed the default log format to include more information.
* Added a test target to Ant that works with JUnit to perform some basic tests, using Oracle as the test database.
* Added ResultSet logging and timing information. By default, this is disabled. Refer to the Log File Format documentation for more information.
* Fixed a number of bugs, in particular a bug that was causing an empty spy.log file to be created and never populated.

## Version 0.6

* Fixed a bug in which null connections were not returning null, but rather empty connections. This was a problem for some applications that were expecting a null connection.
* Added an option to allow the truncation/non-truncation of the log file, which can be specified within spy.options.


