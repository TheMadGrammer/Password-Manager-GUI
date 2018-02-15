#include <SoftwareSerial.h>
#define BT_RX 13
#define BT_TX 12
#define BAUD 9600
#define Front 7
#define Back 6
#define Right 2
#define Left 4
#define moveSpeed 5
#define turnSpeed 3
SoftwareSerial bt(BT_RX, BT_TX);
char c = ' ';
String string = "";
String stringg = "";
int vel = 0;
int len = 0;
int turn = 0;
String toprint = "Vel is: ";
String thang = "Turn is: ";
long PreviousMillis=0;
long interval=10000;
void setup() {
  // put your setup code here, to run once:

  pinMode(BT_TX, OUTPUT);
  pinMode(BT_RX, INPUT);
  bt.begin(BAUD);
  Serial.begin(9600);
  //bt.println("press a key");
    //if (bt.available())  Serial.write("available");
     //Serial.println("Arduino is ready");
     //Serial.println("Remember to select Both NL & CR in the serial monitor");

}

void loop() {
  // put your main code here, to run repeatedly:
 // Keep reading from HC-05 and send to Arduino Serial Monitor
    if (bt.available() > 0) {
      unsigned long CurrentMillis = millis();
      if (CurrentMillis - PreviousMillis < interval) {  
        PreviousMillis = CurrentMillis;
        c = ' ';
        string = "";
        stringg = "";
      /*  while (true) {
          c = bt.read();
          String blah = (String)c + "<>";
          Serial.print(blah);
         
          if (c == '?') {
            Serial.println("My Dad is stupid!");
            break;
           }
           string += (String)c;
          } */
        while (true) {
          c = bt.read();
          if (c == '?') {
            c = bt.read();
            break;
          }
          string += (String)c;
          String blah2 = "";
          blah2 = (String)c + "<>";
          //Serial.print(blah2);
        }
        turn = scale((String)c);
        vel = scale(string);
        //string = "";
        
        //len = string.length();
        Serial.print(vel);
        Serial.print(" ");
        Serial.println(turn);
        if (vel < 0) {
           digitalWrite(Back, LOW);
           digitalWrite(Front, HIGH);
           analogWrite(moveSpeed, int(-vel * .8));
           //Serial.println("Forward!");
        } else {
          digitalWrite(Front, LOW);
          digitalWrite(Back, HIGH);
          analogWrite(moveSpeed, int(vel * .8));
          //Serial.println("Backwards!");
        }
        if (turn == 1) {
          digitalWrite(Right, HIGH);
          digitalWrite(Left, LOW);
          analogWrite(turnSpeed, 50);
        } else if (turn == 2) {
          digitalWrite(Left, HIGH);
          digitalWrite(Right, LOW);
          analogWrite(turnSpeed, 40);
        } else if (turn == 3) {
          digitalWrite(Left, LOW);
          digitalWrite(Right, HIGH);
          analogWrite(turnSpeed, 100);
        } else if (turn == 4) {
          digitalWrite(Left, HIGH);
          digitalWrite(Right, LOW);
          analogWrite(turnSpeed, 90);
        } else {
          digitalWrite(Left, LOW);
          digitalWrite(Right, LOW);
          analogWrite(turnSpeed, 0);
        }
        
      } //end time interval    
    }  //else {
      //Serial.println("HI");
    //}
 
    // Keep reading from Arduino Serial Monitor and send to HC-05
   /* if (Serial.available())
    {
        c =  Serial.read();
        bt.write(c); 
    } */

}

   int scale(String var) {
    
    int iVar = var.toInt();
    //int iVar = (unsigned long)dVar;
    return (iVar);
   }

