
from Stats import query
import json
from CircleMap import CircleMap
import webbrowser
from __builtin__ import raw_input

FILE =   '../../input/map_data.json'  
stats = query()
map = CircleMap()
url = map.createURL(FILE)
json_data = open(FILE)
data = json.load(json_data)

#get a list of cities input to calculate total distance        
def totalDis(): 
    clist = []
    while True:
        listinpt = raw_input("Please enter city list or 'q' to quit:")
        clist.append(listinpt)
        if (listinpt == 'q'):
            break
    print stats.TotalDistance(clist)

#get a list of cities input to calculate total cost     
def totalcost(): 
    clist = []
    while (1):
        listinpt = raw_input("Please enter city list or 'q' to quit:")
        if (listinpt == 'q'):
            break
        else: 
            clist.append(listinpt)

    print stats.TotalCost(clist)
    
#get a list of cities input to calculate total time    
def totaltime(): 
    clist = []
    while (1):
        listinpt = raw_input("Please enter city list or 'q' to quit:")
        if (listinpt == 'q'):
            break
        else: 
            clist.append(listinpt)

    print stats.TotalTime(clist)
    
#remove city    
def removec():
    cityCode =  raw_input("Please enter city code:")
    stats.removeCity(cityCode)
    print stats.allCities()
    
#reove route    
def remover():
    cityCode1 = raw_input("Please enter departure airport code:")
    cityCode2 = raw_input("Please enter arrive airport code:")
    stats.removeRoute(cityCode1, cityCode2)

#add city    
def addc():
    name = raw_input("Please enter city name:")
    code = raw_input("Please enter city code:")
    country = raw_input("Please enter country:")
    timezone = raw_input("Please enter timezone:")
    continent = raw_input("Please enter continent:")
    NS = raw_input("Please enter 'N' or 'S':")
    NSV = raw_input("Please enter latitude value:")
    EW = raw_input("Please enter 'E' or 'W':")
    EWV = raw_input("Please enter longitude value:")
    popu = raw_input("Please enter population:")
    region = raw_input("Please enter region:")
    stats.addCity(name, code, country, continent, timezone, NS, NSV, EW, EWV, popu, region)

#add route    
def addr():
    cityCode1 = raw_input("Please enter departure airport code:")
    cityCode2 = raw_input("Please enter arrive airport code:")
    distance = raw_input("Please enter distance:")
    stats.addRoute(cityCode1, cityCode2, distance)
    
#edit city   
def edit():
    name = raw_input("Please enter the city you want to edit:")
    code = raw_input("Please enter city code if you don't want to change it enter 0:")
    country = raw_input("Please enter country if you don't want to change it press enter:")
    timezone = raw_input("Please enter timezone if you don't want to change it enter 0:")
    continent = raw_input("Please enter continent if you don't want to change it press enter:")
    popu = raw_input("Please enter population if you don't want to change it enter 0:")
    region = raw_input("Please enter region if you don't want to change it enter 0:")
    stats.editCity(name, code, country, continent, timezone, popu, region)
    
    
class Input():
    
        
    # Translate raw input
    # into function commands in real time
    #
    # @input command to be translate 
    def translate(self, command):
        
        if ('list all'    in command or 
            'all cities'  in command): 
            print stats.allCities()
            
        if ('average'     in command and 
            ('population' in command )):
            print stats.averagePopulation()
            
        if ('continents' in command):
            print stats.continentGrouping()
            
        if ('-c ' in command):
            index = command.find('-c ') + 3
            location = command[index:]
            print stats.cityInfo(location)

        if ('biggest' in command and 
            'city'    in command): 
            print stats.biggestCity()
            
        if ('smallest' in command and 
            'city'     in command): 
            print stats.smallestCity()
            
        if ('longest' in command and 
            'flight'  in command): 
            print stats.longestFlight()
            
        if ('shortest' in command and 
            'flight'   in command): 
            print stats.shortestFlight()
        
        if ('Map' in command):
            webbrowser.open(url,new=2)
            print "Routes map created "
                    
        if ('removec' in command):
            removec()
        
        if ('remover' in command):
            remover()
            
        if ('addCity' in command):
            addc() 
        if ('addRoute' in command):
            addr()
            
        if('totalDis' in command):
            totalDis()
            
        if('totalcost' in command):
            totalcost()
            
        if('totaltime' in command):
            totaltime()
        
        if ('edit' in command):
            edit()
        
        if ('save' in command):
            stats.saveToDisk()
            


            
                   


if __name__ == '__main__':
    inpt = Input()
    stats = query()
    
    print ">> Waiting for input....."
    
    while (1):
        command = raw_input('>> ')
        if (command=='quit'):
            break
        else:
            print 'input: ' + command
            inpt.translate(command)
