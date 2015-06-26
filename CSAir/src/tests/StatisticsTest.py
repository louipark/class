
import unittest;
from control.Stats import query

import json


FILE =  '../../input/map_data.json'
json_data = open(FILE)
data = json.load(json_data)

class StatsTest(unittest.TestCase):
    
    def testTotaldis(self):
        stats =query()
        clist = ['SHA','TYO','SFO']
        totaldis = stats.TotalDistance(clist)
        self.assertEqual(totaldis, 10078)
  
    def testTotalcost(self):
        stats =query()
        clist = ['SHA','TYO','SFO']
        totalcost = stats.TotalCost(clist)
        self.assertEqual(str(totalcost), '3112.5')
        
    def testTotaltime(self):
        stats =query()
        clist = ['SHA','TYO','SFO']
        totaltime = stats.TotalTime(clist)
        self.assertEqual(str(totaltime), '18.8373333333')        
    
    
    def testMerge(self):
        stats = query()
        cityinfo = stats.cityInfo("Champaign")
        self.assertEqual(cityinfo.__contains__('Name: Champaign'),True)
        
    #stats tests    
    def testAverage(self):
        stats = query()
        average = stats.averagePopulation()
        self.assertEqual(average,11560018) 
    
    def testSmallestCity(self):
        stats = query()
        smallest = stats.smallestCity()
        self.assertEqual(smallest,'Champaign (226000)')
    
    def testBiggestCity(self):
        stats = query()
        biggest = stats.biggestCity()
        self.assertEqual(biggest,'Tokyo (34000000)')
        
    def testLongestFlight(self):
        stats = query()
        longest = stats.longestFlight()
        self.assertEqual(longest,'SYD to LAX (12051)')
    
    def testShortestFlight(self):
        stats = query()
        shortest = stats.shortestFlight()
        self.assertEqual(shortest,'CMI to CHI (132)')
    
if __name__ == '__main__':
    unittest.main()