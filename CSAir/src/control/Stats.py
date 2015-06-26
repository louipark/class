
import json
import sys
from Parse import Graph
import vertex
import edge
import math

FILE =  '../../input/map_data.json'
F2 = '../../input/cmi_hub.json'
json_data = open(FILE)
json_data1= open(F2)
data = json.load(json_data)
data1 = json.load(json_data1)

graph = Graph()
Cities = graph.parsemetro(data)
Routes = graph.parseroute(data)


class query():
    
     
    # Prints out all the cities
    def allCities(self):
        for city in Cities:
            print city.name
            
    # Calculate the average of all the populations
    # of the cities
    #
    # @return the average city population
    def averagePopulation(self):
        popu = 0
        count = 0
        for city in Cities:
            popu += city.population  
            count = count + 1
        
        average = popu/count
        return average

        
    # Give a list of continents contains 
    # CSAir and which cities are in them
    def continentGrouping(self):
        grouping = {}
        
        for city in Cities:
            grouping[city.continent] = []
            
        for city in Cities:
            grouping[city.continent].append(city.name)
        
        for Continent in grouping:
            
            print str(Continent)
            print grouping[Continent]
            print "\n"
            

        
    # Prints out specific city info
    #
    # @input the city 
    def cityInfo(self,cityName):
        for city in Cities:
            if (city.name == cityName):
                return ('Name: '+ city.name + '\nCode: ' + city.code 
                + '\nCountry: ' + city.country + '\nContinent: ' + city.continent
                + '\nTimezone: ' + str(city.timezone) + '\nCoordinates: ' + str(city.coordinates)
                + '\nPopulation: ' + str(city.population) + '\nRegion: ' + str(city.region))
        
    
    # Gets the name of the biggest city
    def biggestCity(self):
        biggest = ''
        maxVal = 0
        for city in Cities:
            curPop = city.population
            if (curPop > maxVal): 
                maxVal  = curPop
                biggest = city.name
        
        return biggest + " (" + str(maxVal) + ")"
        
    
    # Gets the name of the smallest city
    def smallestCity(self):
        smallest = ''
        minVal = sys.maxint
        for city in Cities:
            curPop = city.population
            if (curPop < minVal): 
                minVal  = curPop
                smallest = city.name
        
        return smallest + " (" + str(minVal) + ")"
    
    # Gets the longest route CSAir has
    # @return the longest route 
    def longestFlight(self):
        longest = 0
        start = ''
        end = ''
        for route in Routes:
                if (longest < route.distance):
                    longest =route.distance
                    start = route.sPort
                    end = route.ePort
        
        return start + " to " + end + " (" + str(longest) + ")"
    
    # Gets the shortest route CSAir has
    # @return the shortest route 
    def shortestFlight(self):
        shortest = sys.maxint
        start = ''
        end = ''
        for route in Routes:
                if (shortest > route.distance):
                    shortest = route.distance
                    start = route.sPort
                    end = route.ePort
        
        return start + " to " + end + " (" + str(shortest) + ")"
    
    # Gets the total distance of a route
    # @return the totalDistance 
    def TotalDistance(self,clist):
        totalDistance = 0
        for index in range(len(clist)-1):
            currentCity, nextCity = clist[index], clist[index+1]
            for route in Routes:
                if(route.sPort == currentCity and route.ePort == nextCity):
                    totalDistance += route.distance
        print "Total Distance is " + str(totalDistance)
        return totalDistance 

    # Gets the total cost of a route
    # @return the total cost
    def TotalCost(self,clist):
        totalCost = 0
        FIRST_LEG = 0.35
        REST_LEG = 0.05
        for index in range(len(clist)-1):
            currentCity, nextCity = clist[index], clist[index+1]
            for route in Routes:
                if(route.sPort == currentCity and route.ePort == nextCity):
                    Distance = route.distance
            if index >= (FIRST_LEG/REST_LEG):
                break
            totalCost += Distance * (FIRST_LEG - (index * REST_LEG))
        print "Total Cost is " + str(totalCost)
        return totalCost
   
   
    # Gets the total time of a route
    # @return the total time    
    #https://github.com/rodrig67/CSAir/blob/master/query/Statistics.py
    def TotalTime(self,clist):
        totalTime = 0.0
        numOutboundFlights = 0
        ACCELERATION = 1406.25
        TOP_VELOCITY = 750.0
        ACEL_TIME = 8/15.0
        for i in range(len(clist) - 1):
            currentCity, nextCity = clist[i], clist[i + 1]
            for route in Routes:
                if(route.sPort == currentCity and route.ePort == nextCity):
                    distance = route.distance
            if distance >= 400:
                distanceTopVel = distance - 400.0
                time = distanceTopVel / TOP_VELOCITY
                totalTime += (ACEL_TIME * 2) + time
            else:
                halfFlightDistance = distance / 2.0
                time = math.sqrt((halfFlightDistance * 2.0) / ACCELERATION)
                totalTime += (time * 2.0)
                for city in Cities:
                    if (city.name == currentCity ):
                        numOutboundFlights = len(city.flights)
            totalTime += (120 - ((numOutboundFlights - 1) * 10)) / 60.0
        
        print "Total Time is " + str(totalTime) + " hours"
        return totalTime                    

    #remove a route
    def removeRoute(self,sport,eport):
        for route in Routes:
            if (route.sPort == sport and route.ePort==eport):
                Routes.remove(route)
                
    #remove a city
    def removeCity(self,cityCode):
        for city in Cities:
            if(city.code == cityCode):
                Cities.remove(city)
        for route in Routes:
            if (route.sPort == cityCode ):
                Routes.remove(route)
            if(route.ePort == cityCode):
                Routes.remove(route)

    #add a city
    def addCity(self,name,code,country,continent,timezone,NS,NSV,EW,EWV,popu,region):
        cityCoordinates = {}
        cityName = name
        cityCode = code
        cityCountry = country
        cityContinent = continent
        cityTimezone = timezone
        cityNS = NS
        cityNSValue = NSV
        cityEW = EW
        cityEWValue = EWV
        while (True):
            cityPopulation = popu
            if cityPopulation > 0:
                break
        cityRegion = region
        cityCoordinates[cityNS] = cityNSValue
        cityCoordinates[cityEW] = cityEWValue
        pcity = vertex.City(cityCode, cityName, cityCountry, cityContinent, cityTimezone, cityCoordinates, cityPopulation, cityRegion)
        Cities.append(pcity)
        print "Added city " + cityName + " to network."
        
    #add a route
    def addRoute(self,cityCode, ePort, distance):
        Route = edge.RouteInfo(cityCode,ePort,distance)
        Routes.append(Route)
    
    #edit a selected city
    def editCity (self,name,code,country,continent,timezone,popu,region):          
        for city in Cities:
            if(city.name == name):
                if(popu>0 and popu!=0):
                    city.population = popu
                    print city.name + "'s population has been changed to " + str(popu)
                if(code != ""):
                    city.code = code
                    print city.name + "'s code has been changed to " + str(code)
                if(country != ""):
                    city.country = country
                    print city.name + "'s country has been changed to " + str(country)
                if(continent != ""):
                    city.continent = continent
                    print city.name + "'s continent has been changed to " + str(continent)
                if(timezone>0):
                    city.timezone = timezone
                    print city.name + "'s timezone has been changed to " + str(timezone)
                if(region>0):
                    city.region = region
                    print city.name + "'s region has been changed to " + str(region)
    
    #save the modified file to disk
    def saveToDisk(self):
            root = {}
            metros = []
            routes = []
            for city in Cities:
                cityDic = {}
                cityDic["code"] = city.code
                cityDic["name"] = city.name
                cityDic["country"] = city.country
                cityDic["continent"] = city.continent
                cityDic["timezone"] = city.timezone
                cityDic["coordinates"] = city.coordinates
                cityDic["population"] = city.population
                cityDic["region"] = city.region
                metros.append(cityDic)
                
                for route in Routes:
                    routeDic = {}
                    routeDic["distance"] = route.distance
                    routeDic["ports"] = [route.sPort, route.ePort]
                    routes.append(routeDic)
                    
            root["routes"] = routes
            root["metros"] = metros
                    
            with open('saveFile.txt', 'w') as outfile:
                json.dump(root, outfile, sort_keys = True, indent = 4)
        

