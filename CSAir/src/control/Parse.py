
import json
import vertex
import edge

FILE =  '../../input/map_data.json'
F2 = '../../input/cmi_hub.json'
json_data = open(FILE)
json_data1= open(F2)
data = json.load(json_data)
data1 = json.load(json_data1)


class Graph():
    
    #Parse city info into list    
    def parsemetro(self,data):
        cityList = []
        for city in data['metros']:
            pcity = vertex.City(city["code"], city["name"], city["country"], 
                              city["continent"],city["timezone"], city["coordinates"], 
                              city["population"], city["region"])
            for route in data["routes"]:
                if (route["ports"][0] == city["code"]):
                    pcity.flights.append(route["ports"][1])
            for route in data["routes"]:       
                if (route["ports"][1] == city["code"]):
                    pcity.flights.append(route["ports"][0])
            cityList.append(pcity)
            

            
        for city in data1['metros']:
            pcity1 = vertex.City(city["code"], city["name"], city["country"], 
                              city["continent"],city["timezone"], city["coordinates"], 
                              city["population"], city["region"])
            for route in data1["routes"]:
                if (route["ports"][0] == city["code"]):
                    pcity1.flights.append(route["ports"][1])
            for route in data1["routes"]:       
                if (route["ports"][1] == city["code"]):
                    pcity1.flights.append(route["ports"][0])
            cityList.append(pcity1)
        return cityList 
         
    
 
    def parseroute(self,data):
        routeList = []
        for route in data["routes"]:
            Route1 = edge.RouteInfo(route["ports"][0],route["ports"][1],route["distance"])
            routeList.append(Route1)
            Route2 = edge.RouteInfo(route["ports"][1],route["ports"][0],route["distance"])
            routeList.append(Route2)            
        for route in data1["routes"]:
            Route1 = edge.RouteInfo(route["ports"][0],route["ports"][1],route["distance"])
            routeList.append(Route1)
            Route2 = edge.RouteInfo(route["ports"][1],route["ports"][0],route["distance"])
            routeList.append(Route2)  
        return routeList
    


                
            
if __name__ == '__main__':
    graph = Graph()
    graph.parsemetro(data)   
    graph.parseroute(data)     
    

        