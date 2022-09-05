package cl.uchile.dcc.finalreality.exceptions

class InvalidStatValueException(description: String) :
  Exception("The required condition is not met. $description")
