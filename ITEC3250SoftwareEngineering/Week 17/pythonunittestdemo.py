#itec3250 unittest

#import all names/functions from the unittest module
import unittest

def myTestableFunction(a,b):
   """A sample function to test"""
   #try:
   c=a/b
   #except ZeroDivisionError:
   #print('zero division')
   #raise(ZeroDivisionError)

   return a+b

#an object-oriented Python class  
# must be a subclass of the Python TestCase class to use the unittest 
# capabilities (software reuse!)
#A test case class is like a new type
# designed to hold and run tests which you
# specify as statements
class MyTestCase(unittest.TestCase):

  #naming of methods with test_xxx
  # informs Python that this method
  # is a test case
  def test_yourObviousMath(self):
     #to assert something means to  
     # state something that must be true
     self.assertEqual(2+4,6)

  def test_yourObviousComparison(self):
     self.assertTrue(2<4)

  def test_yourFunction(self):
     self.assertEqual(4+5,myTestableFunction(4,5))

     #use the 'resource manager' version
     # of asserting that a block raises a particular error
     with self.assertRaises(ZeroDivisionError):
         myTestableFunction(4,0)

     #use the usual version: an assertion that
     # an exception must be raised by the
     # callable 2nd parameter, when given  
     # the provided arguments
     self.assertRaises(ZeroDivisionError,myTestableFunction,4,0)



  #A test case that will always fail, given the defintion of our 
  # test function above the class
  def test_GuaranteedToFail(self):
     #NOTE this will fail, since the testable function will not 
     # produce a file not found error
     #(it does not attempt any input/output with files)
     
     self.assertRaises(FileNotFoundError,myTestableFunction,4,2)


  #define pre test tasks to run
  #prior to ANY test case
  def setUp(self):
     print('Some pre-test tasks here...')

  #define post test tasks
  def tearDown(self):
     print('Some post-test tasks here...')


if __name__ == '__main__':

   #NOTE by running the main function, all test functions defined 
   # in the test case (defined above) are run
   unittest.main()


