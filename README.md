# DHT11_Api
A RESTful api that can return the DHT11 sensor's data, and an android app can work with it.

## server.py
Run this python script on Raspberry Pi.<br>
Remember to change the GPIO / IP / Port.<br>

**Example Url**
```
http://192.168.1.138:5001/api/v1/temp+hum
```

**Return Sample**
```
{"humidity":83,"temperature":30}
```

## Folder: AndroidClient
An android app that can work with the server.py.<br>
Visit the folder for more information.