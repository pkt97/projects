#/usr/bin/python

""" 
    This is the code to accompany the Lesson 1 (Naive Bayes) mini-project. 
    Use a Naive Bayes Classifier to identify emails by their authors
    
    authors and labels:
    Sara has label 0
    Chris has label 1
"""

import numpy as np    
import sys
from time import time
sys.path.append("../tools/")
from email_preprocess import preprocess
#import preprocess
from sklearn.naive_bayes import GaussianNB

### features_train and features_test are the features for the training
### and testing datasets, respectively
### labels_train and labels_test are the corresponding item labels
features_train, features_test, labels_train, labels_test = preprocess()




#########################################################
### your code goes here ###
#features_train=np.array([['hello'],['bye']])
#features_test=np.array([0,1])
clf=GaussianNB()
t0=time()
clf.fit(features_train,features_test)
print ("training time is",round(time()-t0,3),"s")
t1=time()
print(clf.predict(features_test))
#print ("Author is",pred)
print ("testing time is",round(time()-t1,3),"s")
print ("accuracy is",clf.score(features_test,labels_test1))

#########################################################