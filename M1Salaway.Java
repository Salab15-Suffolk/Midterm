/// Midterm code for 59CST112
/////strings////

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Brian Salaway";


//// GLOBALS FOR 3 colored balls ////
//// (Assume ball diameter is 30.) ////

float boardX, boardY, boardDX, boardDY;
float penX, penY, penDX, penDY;
float sailX, sailY, sailDX, sailDY;
float left, right, top, bottom;
float middle;
boolean wall=true;
int tablered=150, tablegreen=250, tableblue=150;
int Z=30;

////SETUP: size and table
void setup() {
  size(640, 480);
  left=50;
  right= width-50;
  top= 100;
  bottom=height-50;
  middle=left+(right-left)/2;
  
  reset();
}

void reset(){
  
  /////////////////////////////////////////Starting positions
  
  boardX=(width*2/3); boardY= random(top, bottom);
  penX=(width*2/3); penY=random(top, bottom);
  sailX=(width*2/3); sailY=random(top, bottom);
  
  ////////////////////////////////////////Random Speeds
boardDX=  random( 1,3 );   boardDY=  random( 1,3 );
penDX=  random( 1,3 );   penDY=  random( 1,3 );
sailDX=  random( 1,3 );   sailDY=  random( 1,3 );
}
void draw(){
  background(250,350,200);
  table (left,top,right, bottom);
  buttons();
  bounce();
  collisions();
  show();
  messages();
}

  //////////////////////////////////////////Table
  void table( float left, float right, float top, float bottom){ 
    fill (tableRed, tableGreen, tableBlue ); ////////green table
    strokeWeight(20);
    stroke(127,0,0); //////walls
    rect(left-20, top-20, right+20, bottom+20);
  
  ///////////////////////////////WALL down Middle
if (wall) {
float middle=(left+right)/2;
stroke(0, 127,0);
line (middle, top+10, middle, bottom-10);
}
 /////////////////Action bouncing and colliding
 bounce() ;
boardX+=boardDX; if (boardX<left || boardX>right) boardDX*=-1;
boardY+=boardDY; if (boardY<top || boardY>bottom) boardDY*=-1; 
penX+=penDX; if (penX<left || penX>right) penDX*=-1;
penY+=penDY; if (penY<top || penY>bottom) penDY*=-1;
sailX+=sailDX; if (sailX<left || sailX>right) sailDX*=-1;
sailY+=sailDY; if (sailY<top || sailY>bottom) sailDY*=-1;
 }
 void collisions(){
   float tmp;
   if (dist(boardX, boardY, penX, penY) <30){
     tmp=penDX; penDX=boardDX; boardDX=tmp;
     tmp=penDY; penDY=boardDY; boardDY=tmp;
   }
   if (dist(boardX, boardY, sailX, sailY) <30){
     tmp=sailDX; sailDX=boardDX; boardDX=tmp;
     tmp=sailDY; sailDY=boardDY; boardDY=tmp;
   }
  if (dist(penX, penY, sailX, sailY) <30){
     tmp=sailDX; sailDX=penDX; penDX=tmp;
     tmp=sailDY; sailDY=penDY; penDY=tmp;
   }
 fill( 255,0,0 );    ellipse( boardX,boardY, 30,30 );
  fill( 255,255,0 );  ellipse( penX,penY, 30,30 );
  fill( 0,0,255 );    ellipse( sailX,sailY, 30,30 ); 
 } 
 void buttons(){
 }
 
 void messages (){
   fill(0);
   text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );
   
  /////////////////////////////////////////////////Keys
  void keyPressed(){
  if (key=='r'){
    reset();
  }
  //////////////////////////////////////////////Wall removal
  if(key=='w'){
  float middle=(left+right)/1000;
  }
  
  //////////////mouse clicking to right side
  if (mouseX >= boardX -Z || mouseX < boardX + Z && mouseY >=boardY -Z || 
   mouseY <boardY + Z ){
     reset();
   } 
    if (mouseX >= penX -Z || mouseX < penX + Z && mouseY >=penY -Z || 
   mouseY <boardY + Z ){
     reset();
   } 
   if (mouseX >= sailX -Z || mouseX < sailX + Z && mouseY >=sailY -Z || 
   mouseY <sailY + Z ){
     reset();
   } 
  

}
  

  
 
   


