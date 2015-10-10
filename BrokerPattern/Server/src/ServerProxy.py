import socket
import sys
from _thread import *

HOST = ''	# Symbolic name, meaning all available interfaces
PORT = 8888	# Arbitrary non-privileged port

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print ('Socket created')

#Bind socket to local host and port
try:
    s.bind((HOST, PORT))
except socket.error as msg:
    print ('Bind failed. Error Code : ' + str(msg[0]) + ' Message ' + msg[1])
    sys.exit()

print ('Socket bind complete')

#Start listening on socket
s.listen(10)
print ('Socket now listening')

def clientthread(cnn):
    str = 'Hola! soy un servidor python\n'
    cnn.send(str.encode())

    while True:
        data = cnn.recv(1024)
        reply = 'OK...' + data.decode()
        if not data:
            break
        cnn.sendall(reply.encode())

    cnn.close()

#now keep talking with the client
while 1:
    #wait to accept a connection - blocking call
    conn, addr = s.accept()
    print ('Connected with ' + addr[0] + ':' + str(addr[1]))
    start_new_thread(clientthread,(conn,))

s.close()
