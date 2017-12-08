# Juego del Ahorcado - Versión: 1.0.
Copyleft 2017 - Jesús Cuerda - Todos los errores reservados.

Esta aplicación revive el clásico juego de lápiz y papel 'El Ahorcado'.

Aplicación gratuita y sin publicidad.

## REQUISITOS

Aplicación multiplataforma desarrollada con lenguaje de programación JAVA (OpenJDK 8). Requiere tener instalado JRE (Java Runtime Environment) disponible en la [web de Oracle](https://www.java.com/es) o su versión libre [OpenJDK](http://openjdk.java.net/).

En **linux**, según la distribución, el paquete de la versión libre puede recibir distintos nombres, como openjdk-8, openjdk-8-jre o java-1.8.0-openjdk.

### IMPORTANTE

Esta aplicación utiliza tecnología **JavaFX** combinada con Java para presentar la interfaz gráfica de la aplicación. Actualmente JavaFX forma parte de Java SE de Oracle pero no está integrado completamente en OpenJDK, por lo que si utiliza OpenJDK tendrá que instalarlo de manera independiente.

Igual que OpenJDK, existe una versión libre de JavaFx: [**OpenJFX**](https://wiki.openjdk.java.net/display/OpenJFX/Main), que al igual que OpenJDK es software libre bajo licencia GPL.

Puede encontrar OpenJFX en los repositorios de la mayoría de distribuciones linux empaquetado bajo distintos nombres, como openjfx-8, openjfx o java-openjfx.

## EJECUTAR

La aplicación no instala nada en tu sistema, simplemente ejecuta el archivo jar para empezar a jugar.

Descarga el archivo **Ahorcado.zip**, extrae su contenido y ejecuta el archivo **Ahorcado.jar**. Si no se inicia con doble clic del ratón, desde consola ejecuta este comando desde el directorio descomprimido:

`java -jar Ahorcado.jar`

En linux puedes crear un lanzador para el escritorio o para el menú de aplicaciones creando el archivo ahorcado.desktop

Por ejemplo:

`sudo gedit /usr/share/applications/ahorcado.desktop`

Y copia lo siguiente cambiando la ruta del icono y de la aplicación:

    [Desktop Entry]
    Version=1.0
    Type=Application
    Name=Ahorcado
    Comment=Ahorcado Launcher
    Icon=RUTA DEL ICONO, POR EJEMPLO: /home/usuario/Ahorcado/icon.png
    Exec=java -jar Ahorcado.jar
    Path=RUTA DEL DIRECTORIO, POR EJEMPLO: /home/usuario/Ahorcado/
    NoDisplay=false
    Categories=Game;
    StartupNotify=false
    Terminal=false

## LICENCIA

Software libre de código abierto sujeto a la GNU General Public License v.3. EL AHORCADO es software libre distribuido con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA.

This file is part of EL AHORCADO.

EL AHORCADO is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation either version 3 of the License.

EL AHORCADO is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. https://www.gnu.org/licenses/gpl-3.0.txt

