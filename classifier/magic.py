from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score
import csv
import numpy as np
import json
import sys

def get_data():
    """
    Loads the train and test data from the csv file
    """

    with open('prepdata.csv') as csvfile:
        reader = csv.DictReader(csvfile, delimiter=';')
        #print(reader.fieldnames)

        data = []
        for dic in reader:
            for k in dic.keys():
                if dic[k] is None or dic[k] == '' or dic[k] == '0':
                    dic[k] = 0
                if dic[k] == '1':
                    dic[k] = 1
                try:
                    dic[k] = float(dic[k])
                except:
                    raise RuntimeError()
            data.append(dic)

        return data

def prepare_data(data):
    labels = [r["Label"] for r in data]
    labels = np.array(labels).astype(np.float)

    # Organize our data
    label_names = ['score']
    labels #= data['target']
    featurenames = [str(k) for k in data[0].keys() if k != "Label"]#['damageSource', 'nrDamages', 'nr_images']

    #features = [[r["damageSource"], r["nrDamages"], r["nr_images"]] for r in data]
    features = [[r[name] for name in featurenames] for r in data]
    features = np.array(features).astype(np.float)


    #print("labels: " + str(labels))
    #print("features: " + str(features))
    #print("Shape labels: " + str(labels.shape))
    #print("Shape features: " + str(features.shape))
    #print(label_names)
    #print('Class label = ', labels[0])
    #print(featurenames)
    #print(features[0])
    return features, labels

def split_data(data):
    
    features, labels = prepare_data(data)
    # Split the data
    train, test, train_labels, test_labels = train_test_split(features,
                                                            labels,
                                                            test_size=0.33,
                                                            random_state=42)

    return train, test, train_labels, test_labels

def train_model(train, train_labels):
    # Initialize the classifier
    gnb = GaussianNB()

    # Train our classifier
    model = gnb.fit(train, train_labels)

    return gnb, model

def test_model(gnb, test, test_labels):
    # Make predictions
    preds = gnb.predict(test)
    #print(preds)
    #print(test)

    # Evaluate accuracy
    #print(accuracy_score(test_labels, preds))

def prepare_data_for_evaluation(data):

    featurenames = [str(k) for k in data[0].keys() if k != "Label"]

    features = [[r[name] for name in featurenames] for r in data]
    features = np.array(features).astype(np.float)

    return features

def evaluate(gnb, features):
    preds = gnb.predict(features)
    return preds

if __name__ == "__main__":
    data = get_data()
    train, test, train_labels, test_labels = split_data(data)
    gnb, model = train_model(train, train_labels)
    test_model(gnb, test, test_labels)

    # this is a sample input
    jsonstring="""
{
    "Vandalismus": 0,
    "Uberschwemmung": 0,
    "Offerte vorhanden": 0,
    "Feuer": 0,
    "Regenwasser": 0,
    "Gebaudetechnik": 0,
    "Eigenleistung": 0,
    "Sturmwind": 0,
    "Rechnung vorhanden?": 0,
    "Grundwasser": 0,
    "Hagel": 0,
    "Leitungsbruch": 0,
    "Glasbruch": 0,
    "Marder": 1,
    "Schaden behoben": 0,
    "Selbsteinsch": 0,
    "Blitzschlag": 0,
    "Hochwasser": 0,
    "Erdrutsch": 0,
    "uberspannung bei Gewitter": 0,
    "Fachauskunft": 0
}
    """

    jsonstring = sys.stdin.read()

    data = [json.loads(jsonstring)]
    features = prepare_data_for_evaluation(data)
    result = evaluate(gnb, features)

    print(result[0])


