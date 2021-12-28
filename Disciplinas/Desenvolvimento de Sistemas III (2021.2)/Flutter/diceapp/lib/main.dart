import 'package:flutter/material.dart';

import 'pages/dados.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'DiceApp',
      home: Scaffold(
        backgroundColor: Colors.teal[800],
        appBar: AppBar(
          title: const Text('DiceApp', style: TextStyle(fontSize: 25, color: Colors.black)),
          backgroundColor: Colors.tealAccent[400],
        ),
        body: Dados(),
      ),
    );
  }
}
