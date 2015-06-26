from Tkinter import *
import io
import tkMessageBox
import base64
from urllib2 import urlopen
from Stats import query
import json
from CircleMap import CircleMap
from Parse import Graph

FILE =   '../../input/map_data.json'  
stats = query()
map = CircleMap()
url = map.createURL(FILE)
newurl = url + '&MS=wls&MR=1800&MX=720x360&PM=*'
json_data = open(FILE)
data = json.load(json_data)
graph = Graph()
Cities = graph.parsemetro(data)



class App():
    
    def __init__(self, master):
        frame = Frame(master)
        frame.pack()
        
        #create a series buttons on the frame
        self.shortest = Button(frame, text="Shortest Flight", command=self.shortestRoute,width = 100)
        self.shortest.pack()
        
        self.longest = Button(frame, text="Longest Flight", command=self.longestRoute, width = 100)
        self.longest.pack()
        
        self.biggest = Button(frame, text="Biggest City", command=self.biggestCity, width = 100)
        self.biggest.pack()
        
        self.smallest = Button(frame, text="Smallest City", command=self.smallestCity, width = 100)
        self.smallest.pack()
        
        self.average = Button(frame, text="Average Population", command=self.averagePopu, width = 100)
        self.average.pack()
        
        self.routeinfo = Button(frame, text="Route info", command=self.totalDistance, width = 100)
        self.routeinfo.pack()
            
        self.savefile = Button(frame, text="Save file", command=self.savefile, width = 100)
        self.savefile.pack()
            
        self.allcities = Button(frame, text="List All Cities", command=self.viewCities, width = 100)
        self.allcities.pack()
        
        self.showmap = Button(frame, text="Show Route Map", command=self.showmap, width = 100)
        self.showmap.pack()
        
        self.remover = Button(frame, text="Remove route", command=self.remover, width = 100)
        self.remover.pack()
        
    #create a series message box which will pop out when buttons are clicked  
    def shortestRoute(self):
        route = stats.shortestFlight()
        tkMessageBox.showinfo("ShortestFlight","The Shortest Flight is "+route)
             
    def longestRoute(self):
        route = stats.longestFlight()
        tkMessageBox.showinfo("longestFlight","The Longest Flight is "+route)
       
        
    def biggestCity(self):
        city =  stats.biggestCity()
        tkMessageBox.showinfo("BiggestCity","The Biggest city is "+city) 
        
    def smallestCity(self):
        city =  stats.smallestCity()
        tkMessageBox.showinfo("SmallestCity","The Smallest city is "+city) 
        
    def averagePopu(self):
        popu = stats.averagePopulation()
        tkMessageBox.showinfo("AveragePopulation","The Average population of all cities is "+str(popu)) 
        
    def savefile(self):
        stats.saveToDisk()
        tkMessageBox.showinfo("Save","The File Saved!")
        
    #create a new window to display the city info
    def viewCities(self):
        w = Tk()
        w.title('All cities')
        w.geometry('200x400')
        
        #create a list box to show cities
        listbox = Listbox(w)
        listbox.pack()
        listbox.insert(END, "a list entry")
        cities = []
        for city in Cities:
            cities.append(city.name)
        for item in cities:
            listbox.insert(END,item)
        
        #a func to get selection and pops out a message box to show cityinfo   
        def callback():
            cityname = listbox.get(listbox.curselection())
            info = stats.cityInfo(cityname)
            tkMessageBox.showinfo(cityname,info)
        
        #create a button to call the cityinfo message box 
        self.showinfo = Button(w, text="Show selected city info", command=callback )
        self.showinfo.pack()
        
    #create a new window to display map    
    def showmap(self):
        tl = Toplevel()
        tl.title('Route Map')
        tl.geometry("%dx%d+%d+%d" % (720, 360, 10, 100))
        image_bytes = urlopen(newurl).read()
        image_b64 = base64.encodestring(image_bytes)    
        photo = PhotoImage(data=image_b64)
        label = Label(tl,image=photo).pack()
        label.image = photo
        
    def remover(self):
        tl = Toplevel()
        tl.title("remove route")
        Label(tl,text = "Please input first city code:").pack(side = TOP)
        city1 = Entry(tl)
        city1.pack(side = TOP)
        Label(tl,text = "Please input second city code:").pack(side = TOP)
        city2 = Entry(tl)
        city2.pack(side = TOP)
        
        def getc():
            stats.removeRoute(city1, city2)
            tkMessageBox.showinfo("remove r","Route removed")
        
        self.b = Button(tl,text="comfirm", command=getc)
        self.b.pack(side = BOTTOM)
        
            
        
    #create a new window to get city list input from user and calculate total distance    
    def totalDistance(self):
        tl = Toplevel()
        tl.title("Total Distance")
        Label(tl,text = "Please input first city code:").pack(side = TOP)
        city1 = Entry(tl)
        city1.pack(side = TOP)
        Label(tl,text = "Please input second city code:").pack(side = TOP)
        city2 = Entry(tl)
        city2.pack(side = TOP)
        Label(tl,text = "Please input third city code:").pack(side = TOP)
        city3 = Entry(tl)
        city3.pack(side = TOP)
        Label(tl,text = "Please input forth city code:").pack(side = TOP)
        city4 = Entry(tl)
        city4.pack(side = TOP)
        
        def getcode():
            code1 = city1.get()
            code2 = city2.get()
            code3 = city3.get()
            code4 = city4.get()
            codelist = [code1,code2,code3,code4]
            dis = stats.TotalDistance(codelist)
            cost = stats.TotalCost(codelist)
            time = stats.TotalTime(codelist)
            tkMessageBox.showinfo("route info","Total Distance is " + str(dis)+"\n"+"Total Cost is "+str(cost) + "\n"+"Total Time is " + str(time))
            
        self.b = Button(tl,text="comfirm", command=getcode)
        self.b.pack(side = BOTTOM)
        


        
        
win = Tk()
win.title('CSair')
win.geometry('200x330') 
menubar = Menu(win)
menubar.add_command(label="Quit!",command=win.quit)

win.config(menu=menubar)
app = App(win)


# Code to add widgets will go here...
win.mainloop()