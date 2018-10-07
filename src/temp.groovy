
def file = new File('../data/fells_loop_truncated.xml')
//println file.exists()
def sampler = new XmlSlurper()
def xml = sampler.parse(file)
//println(xml.getBody())
xml.route.routepoint.each{ t ->
    println  t.latitude
}
