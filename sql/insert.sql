mysql -u root -p
sudo /etc/init.d/apache2 restart   sudo service apache2 restart
sudo /etc/init.d/mysql restart

clion CMakeList.txt

cmake_minimum_required(VERSION 3.x)  
project(xxx)  
  
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")    //c++11 compiler
set(CUDA_USE_STATIC_CUDA_RUNTIME OFF) #stop CUDA  
set(SOURCE_FILES main.cpp)  
find_package(OpenCV REQUIRED) #find opencv packets  
add_executable(xxxxx ${SOURCE_FILES} )  
target_link_libraries(xxxx ${OpenCV_LIBS}) #add opencv lib 

target_link_libraries(${PROJECT_NAME} GL GLU glut GLEW glfw3 dl X11 Xxf86vm  Xrandr pthread Xi Xcursor Xinerama SOIL)

sudo apt-get install libsoil-dev
https://github.com/kbranigan/Simple-OpenGL-Image-Library

#include "SOIL.h"

#include "cv.h"
#include "opencv2/imgcodecs.hpp"
#include "opencv/cv.hpp"
#include <vector>
using namespace cv;
using namespace std;

service mysql start
mysql -u root -p
1. 如果数据库是GBK格式的
在数据库mysq_connect连接语句后面加上
mysql_query("SET NAMES 'GBK'"); 
2.如果数据库是UTF-8格式的
  在数据库mysql_connect连接语句后面加上
mysql_query("SET NAMES 'UTF8'");
mysql_query("SET CHARACTER SET UTF8"); 
mysql_query("SET CHARACTER_SET_RESULTS=UTF8'"); 

git add filename
git rm --cached filename
git commit -m "hehe"
git push origin

b = b1 * a1/255 + b0 * (255 - a1)/255  
g = g1 * a1/255 + g0 * (255 - a1)/255  
r = r1 * a1/255 + r0 * (255 - a1)/255 

vue init webpack xxx
cnpm install
cnpm run dev

mkdir build
cd build
cmake /home/fu/glfw
make
sudo make install

CTRL+ALT+I 自 动缩进

ls -a查看隐藏文件
