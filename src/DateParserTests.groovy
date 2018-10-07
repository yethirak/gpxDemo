// https://mvnrepository.com/artifact/joda-time/joda-time
@Grapes(
        @Grab(group='joda-time', module='joda-time', version='2.10')
)
import org.joda.time.DateTime

import groovy.util.GroovyTestCase

class DateParserTests extends GroovyTestCase {
    def void testCanParseDateTime(){
        def parser = new DateParser()

        def dateTime = new DateTime(2013,1,1,9,30)
        def result = parser.parse(dateTime.toString())
        assert '01/01/2013 - 09:30 AM' == result
    }

}
