import 'package:flutter/material.dart';
import 'dart:math';

import 'package:diceapp/widgets/dado.dart';

class Dados extends StatefulWidget {
  @override
  _DadosState createState() => _DadosState();
}

class _DadosState extends State<Dados> {
  int dado1 = 1, dado2 = 1;
  var rng = new Random();

  _jogarDados(){
      setState(() {
        dado1 = rng.nextInt(6) + 1;
        dado2 = rng.nextInt(6) + 1;
      });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: InkWell(
          onTap: () { _jogarDados(); },
          child: Row(
            children: [
              _construirDado(dado1),
              _construirDado(dado2),
            ],
          )),
    );
  }

  _construirDado(int dado) {
    return Expanded(
      child: FractionallySizedBox(
        widthFactor: 0.80,
        heightFactor: 0.80,
        child: Image.asset("../img/dice$dado.png"),
      ),
    );
  }
}
