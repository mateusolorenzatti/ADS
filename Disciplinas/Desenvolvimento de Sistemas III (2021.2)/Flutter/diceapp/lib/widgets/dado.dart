import 'package:flutter/material.dart';

class Dado extends StatefulWidget {
  @override
  _DadoState createState() => _DadoState();
}

class _DadoState extends State<Dado> {
  @override
  Widget build(BuildContext context) {
    return 
          Expanded(
            child: FractionallySizedBox(
              widthFactor: 0.80,
              heightFactor: 0.80,
              child: Image.asset("../img/dice1.png"),
            ),
          );
  }
}
