# Multithreaded Web Server Project

## Overview
This project is an implementation of a multithreaded web server in Java. The server is capable of handling multiple client connections concurrently using multithreading techniques.

## Features
- Multithreaded architecture for handling concurrent client connections
- Basic HTTP request handling for serving static content
- Support for persistent connections and basic HTTP methods (GET, POST)
- Simple configuration options for port number and server root directory
- JMeter to simulate realistic load scenarios and measure performance metrics

## Requirements
- Java Development Kit (JDK) installed on your system
- Obviously should know java duhh!
- Apache Jmeter
- good to go

## Usage
1. Compile the server source code using the `javac` compiler.
2. Run the compiled Java bytecode, providing the desired port number and server root directory as command-line arguments.
3. Access the server using a web browser or HTTP client, specifying the appropriate URL to request resources from the server.

## Configuration
The server can be configured by specifying the following parameters:
- Port number: The port on which the server listens for incoming connections.
- Server root directory: The directory from which the server serves static content.

## Example
```bash
$ javac WebServer.java
$ java WebServer 
