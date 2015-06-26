
import webbrowser
import json
from Parse import Graph

FILE =  '../../input/map_data.json'
json_data = open(FILE)
data = json.load(json_data)

graph = Graph()
Routes = graph.parseroute(data)

class CircleMap():
    # Create a URL go to the Great Circle Mapper website 
    # and it display the route map image.
    #
    # @input graph the given graph representation 
    #              for our input
    def createURL(self,data):
        url = "http://www.gcmap.com/map?P="
        
        routes = ""
        for route in Routes:
                routes += route.sPort + "-" + route.ePort + ",+"                        
        url += routes[:-2]
        return url 
            

if __name__ == '__main__':
    map = CircleMap()
    url = map.createURL(data)
    webbrowser.open(url,new=2)
    