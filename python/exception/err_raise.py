#!/usr/bin/env/python3
# -*- coding: utf-8 -*-
__author__='drawnkid@gmail.com'
class FooError(ValueError):
    pass
def foo(s):
    n=int(s)
    if n==0:
        raise FooError('invalid value:%s' % s)
    return 10/n
foo('0')
