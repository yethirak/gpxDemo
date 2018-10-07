@Grapes([
        @Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6')
])

import groovyx.net.http.RESTClient

def file = new File('../data/fells_loop.gpx')
//println file.exists()

// xml parser for quick evaluation xml slurper for lazy evaluation
def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

//Access child
println gpx.name
println ''

/*// extensions
println 'Beginning dump...'
println gpx.name.value.dump()

// Inspect
println 'Beginning inspect...'
println gpx.name.inspect()*/

gpx.with{
    println desc
    println ''
    println attributes()['version']
}
//println gpx.desc
//println ''
//
////Access attributes
//println gpx.@version
//println gpx.@creator
//
def forecastApi = new RESTClient('https://api.darksky.net/')
def apiKey='576e90b0267b5963c37892a032d0821f'
gpx.rte.rtept.each { point ->
    println point.@lat
    println point.@lon

    def parser = new DateParser()
    println parser.parse(point.time.toString())
  
    //REST query String
    def queryString = "forecast/$apiKey/${point.@lat},${point.@lon},,${point.@time}"
    println queryString
    def response = forecastApi.get(path: queryString)
    println response.status
}
