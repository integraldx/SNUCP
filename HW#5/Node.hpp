#pragma once

#include <string>

class Node {
   public:
   static bool Node::isThereOperators(string str)
   {
       bool toReturn = false;
       for (char ch : str)
       {
           if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%')
           {
               toReturn = true;
           }
       }

       return toReturn;
   }
};
