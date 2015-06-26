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
Routes = graph.parseroute(data)

win = Tk()
win.title('Route Map')
win.geometry("%dx%d+%d+%d" % (720, 360, 10, 100))
image_bytes = urlopen(newurl).read()
image_b64 = base64.encodestring(image_bytes)
photo = PhotoImage(data=image_b64)
        
label = Label(win,image=photo)
label.pack()
win.mainloop()