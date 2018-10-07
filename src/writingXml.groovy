def inFile = new File('../data/fells_loop.gpx')
//println file.exists()

// xml parser for quick evaluation xml slurper for lazy evaluation
def slurper = new XmlSlurper()
def gpx = slurper.parse(inFile)

def markupbuilder = new groovy.xml.StreamingMarkupBuilder()
def xml = markupbuilder.bind({
    route{
        mkp.comment(gpx.name)
        gpx.rte.rtept.each{ point ->
            routepoint(timestamp: point.time.toString()) {
                latitude(point.@lat)
                longitude(point.@lon)
            }
        }
    }
})

def outFile = new File('../data/fells_loop_truncated.xml')
outFile.write(xml.toString())

