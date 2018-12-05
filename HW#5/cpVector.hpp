#pragma once
#include <iostream>
#include <assert.h>
#include "cpScalar.hpp"

class cpVector
{
  public:
    cpVector(cpScalar sarr[], unsigned int size);
    ~cpVector();

    friend cpVector operator+(cpVector &left, cpVector &right);
    friend cpVector operator-(cpVector &left, cpVector &right);
    friend cpScalar operator*(cpVector &left, cpVector &right);
    friend cpVector operator/(cpVector &left, cpVector &right);

    friend cpVector operator+(cpScalar &left, cpVector &right);
    friend cpScalar operator-(cpScalar &left, cpVector &right);
    friend cpVector operator*(cpScalar &left, cpVector &right);
    friend cpScalar operator/(cpScalar &left, cpVector &right);

    friend cpVector operator +(cpVector& left, cpScalar& right);
    friend cpVector operator -(cpVector& left, cpScalar& right);
    friend cpVector operator *(cpVector& left, cpScalar& right);
    friend cpVector operator /(cpVector& left, cpScalar& right);

    friend std::ostream &operator<<(std::ostream &os, const cpVector &vec);

  private:
    cpScalar *value;
    unsigned int size;
};

cpVector::cpVector(cpScalar sarr[], unsigned int size)
{
    value = (cpScalar *)calloc(size, sizeof(cpScalar));
    this->size = size;
    for (int i = 0; i < size; i++)
    {
        value[i] = sarr[i];
    }
}

cpVector::~cpVector()
{
    free(value);
}

cpVector operator+(cpVector &left, cpVector &right)
{
    assert(left.size == right.size);
    cpScalar *arr = (cpScalar *)calloc(left.size, sizeof(cpScalar));
    for (int i = 0; i < left.size; i++)
    {
        arr[i] = left.value[i] + right.value[i];
    }
    cpVector toReturn(arr, left.size);
    free(arr);
    return toReturn;
}

cpVector operator-(cpVector &left, cpVector &right)
{
    assert(left.size == right.size);
    cpScalar *arr = (cpScalar *)calloc(left.size, sizeof(cpScalar));
    for (int i = 0; i < left.size; i++)
    {
        arr[i] = left.value[i] - right.value[i];
    }

    cpVector toReturn(arr, left.size);
    free(arr);
    return toReturn;
}

cpScalar operator*(cpVector &left, cpVector &right)
{
    assert(left.size == right.size);
    cpScalar toReturn(0);
    for (int i = 0; i < left.size; i++)
    {
        cpScalar toAdd = (left.value[i] * right.value[i]);
        toReturn = toReturn + toAdd;
    }

    return toReturn;
}

cpVector operator/(cpVector &left, cpVector &right)
{
    assert(left.size == right.size);
    cpScalar *arr = (cpScalar *)calloc(left.size, sizeof(cpScalar));
    cpScalar absSum(0);
    for (int i = 0; i < right.size; i++)
    {
        if ((double)right.value[i] < 0)
        {
            absSum = absSum - right.value[i];
        }
        else
        {
            absSum = absSum + right.value[i];
        }
    }
    for (int i = 0; i < left.size; i++)
    {
        arr[i] = left.value[i] / absSum;
    }
    cpVector toReturn(arr, left.size);
    free(arr);
    return toReturn;
}

std::ostream &operator<<(std::ostream &os, const cpVector &vec)
{
    os << '[';
    for (int i = 0; i < vec.size - 1; i++)
    {
        os << vec.value[i] << ", ";
    }
    os << vec.value[vec.size - 1] << "]";
    return os;
}

cpVector operator+(cpScalar &left, cpVector &right)
{
    cpScalar* arr = (cpScalar*)calloc(right.size, sizeof(cpScalar));
    for (int i = 0; i < right.size; i++) {
        arr[i] = left + right.value[i];
    }

    cpVector toReturn(arr, right.size);
    free(arr);
    return toReturn;
}

cpScalar operator-(cpScalar &left, cpVector &right)
{
    cpScalar absSum(0);
    for (int i = 0; i < right.size; i++)
    {
        if((double)right.value[i] > 0) {
            absSum = absSum + right.value[i];
        }
        else
        {
            absSum = absSum - right.value[i];
        }
    }

    return left - absSum;
}

cpVector operator*(cpScalar &left, cpVector &right)
{
    cpScalar* arr = (cpScalar*)calloc(right.size, sizeof(cpScalar));
    for (int i = 0; i < right.size; i++) {
        arr[i] = left * right.value[i];
    }

    cpVector toReturn(arr, right.size);
    free(arr);
    return toReturn;
}

cpScalar operator/(cpScalar &left, cpVector &right)
{
    cpScalar absSum(0);
    for (int i = 0; i < right.size; i++)
    {
        if((double)right.value[i] > 0) {
            absSum = absSum + right.value[i];
        }
        else
        {
            absSum = absSum - right.value[i];
        }
    }

    return left / absSum;
}

cpVector operator+(cpVector &left, cpScalar &right)
{
    cpScalar* arr = (cpScalar*)calloc(left.size, sizeof(cpScalar));
    for (int i = 0; i < left.size; i++) {
        arr[i] = left.value[i] + right;
    }

    cpVector toReturn(arr, left.size);
    free(arr);
    return toReturn;
}

cpVector operator-(cpVector &left, cpScalar &right) 
{
    cpScalar* arr = (cpScalar*)calloc(left.size, sizeof(cpScalar));
    for (int i = 0; i < left.size; i++) {
        arr[i] = left.value[i] - right;
    }

    cpVector toReturn(arr, left.size);
    free(arr);
    return toReturn;
}

cpVector operator*(cpVector &left, cpScalar &right)
{
    cpScalar* arr = (cpScalar*)calloc(left.size, sizeof(cpScalar));
    for (int i = 0; i < left.size; i++) {
        arr[i] = left.value[i] * right;
    }

    cpVector toReturn(arr, left.size);
    free(arr);
    return toReturn;
}

cpVector operator/(cpVector &left, cpScalar &right)
{
    cpScalar* arr = (cpScalar*)calloc(left.size, sizeof(cpScalar));
    for (int i = 0; i < left.size; i++) {
        arr[i] = left.value[i] / right;
    }

    cpVector toReturn(arr, left.size);
    free(arr);
    return toReturn;
}