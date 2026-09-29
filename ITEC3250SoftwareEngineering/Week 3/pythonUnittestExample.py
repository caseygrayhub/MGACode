#itec3250 
#unittest module example

import unittest 

def mytestableFunction(a,b):

  #NOTE you could use exception handling to prevent the error:
  #this begins the block that would cause the error
  #try:

  #NOTE this will cause the ZeroDivisionError if 
  # the b value passed in is zero
  #Comment it to cause the test to fail
  #c=a/b

  #NOTE you could use exception handling to prevent the error
  #this is an exception handling block to handle the named error
  #except ZeroDivisionError:
   #print('zero division')
   #NOTE this statement intentionally, explicitly raises the error
   #raise(ZeroDivisionError)


  return a+b 




#an object-oriented Python class  must be a subclass of the TestCase
# class to use the module's capabilities (software reuse!) 
#A test case class is like a new type designed to hold and run tests which you 
# specify as statements 
class MyTestCase(unittest.TestCase):

  #naming of methods with test_xxx 
  # informs Python that this method is a test
  #NOTE test 1
  def test_yourObviousMath(self):
    #to assert something means to 
    # state something that must be true 
    self.assertEqual(2+4,6) 
    print("	equality test: is the sum of 2 and 4 equal to 6? (duh)")

  #NOTE test 2
  def test_yourObviousComparison(self):
    print("	truth test: is 2 less than 4? (duh)")
    self.assertTrue(2<4)

  #NOTE our unittest function to test the function 'mytestableFunction'
  #NOTE if any assertion fails, it is a failed test which will be reported
  # by unittest when it runs

  #NOTE test 3
  def test_yourFunction(self):

   print("	testing my function: ")

   #NOTE first test assertion that is obviously true:
   #that the tested function will return the sum of 4 and 5
   self.assertEqual(4+5,mytestableFunction(4,5))

   self.assertEqual(1+1,mytestableFunction(1,1))


   #NOTE try another test: use the 'resource manager' version
   # of asserting that a block raises a particular error
   with self.assertRaises(ZeroDivisionError):
        mytestableFunction(4,0)

   #NOTE the usual version: an assertion that 
   # an exception must be raised by the 
   # callable function (listed as the 2nd parameter), when that function is called with
   # the provided arguments 4 and 0
   self.assertRaises(ZeroDivisionError,mytestableFunction,4,0) 



  #NOTE code to run before testing
  #define pre test tasks 
  def setUp(self): 
      print('	Executing some pre-test tasks here...') 

  #NOTE code to run after testing
  #define pre test tasks 
  #define pre test tasks
  def tearDown(self):
      print('	Executing some post-test tasks here...\n')



#NOTE launch  unittest main function, which will launch
# our test case above defined by the class MyTestCase
unittest.main()
