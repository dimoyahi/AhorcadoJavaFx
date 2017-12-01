Juego del Ahorcado - Versión: 1.0.
Copyleft 2017 - Jesús Cuerda - Todos los errores reservados.

Esta aplicación revive el clásico juego de lápiz y papel 'El Ahorcado'.
Aplicación gratuita y sin publicidad.

############################## REQUISITOS

Aplicación multiplataforma desarrollada con lenguaje de programación JAVA (OpenJDK 8). Requiere tener instalado JRE (Java Runtime Environment) disponible en https://www.java.com/es

En linux, según la distribución, el paquete de la versión libre puede recibir distintos nombres, como openjdk-8, openjdk-8-jre o java-1.8.0-openjdk.

############################## EJECUTAR

Después de descomprimir el archivo zip, tienes varias opciones para arrancar el juego según tu sistema operativo o su configuración. No requiere instalar nada.

Descomprime el archivo zip y entra en la carpeta Ahorcado.

Ejecuta el archivo ahorcado.jar. Si no se inicia con el ratón, desde consola ejecuta este comando:

java -jar ahorcado.jar

Otras opciones son utilizar los archivos run.sh o run.bat. Por ejemplo, en linux desde consola con cualquiera de estos comandos:

./run.sh
sh run.sh

En linux puedes crear un lanzador para el escritorio o para el menú de aplicaciones creando el archivo ahorcado.desktop

Por ejemplo:

sudo gedit /usr/share/applications/ahorcado.desktop

Y copia lo siguiente cambiando la ruta del icono y de la aplicación:

[Desktop Entry]
Version=1.0
Type=Application
Name=Ahorcado
Comment=Ahorcado Launcher
Icon=RUTA DEL ICONO, POR EJEMPLO: /home/usuario/Ahorcado/icon.png
Exec=java -jar ahorcado.jar
Path=RUTA DEL DIRECTORIO, POR EJEMPLO: /home/usuario/Ahorcado/
NoDisplay=false
Categories=Game;
StartupNotify=false
Terminal=false

############################## LICENCIA
Software libre de código abierto sujeto a la GNU General Public License v.3. EL AHORCADO es software libre distribuido con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA.

This file is part of EL AHORCADO.

EL AHORCADO is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation either version 3 of the License.

EL AHORCADO is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. https://www.gnu.org/licenses/gpl-3.0.txt

