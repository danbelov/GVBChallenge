from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score
import csv
import numpy as np

# Load dataset
#data = load_breast_cancer()
#data = pd.read_csv("data.csv")

with open('data.csv') as csvfile:
    reader = csv.DictReader(csvfile, delimiter=';')
    print(reader.fieldnames)
    data = [r for r in reader]
    print(data)

    labels = [r["score"] for r in data]
    labels = np.array(labels).astype(np.float)
    #labels = labels.reshape(1, -1)


    features = [[r["damageSource"], r["nrDamages"], r["nr_images"]] for r in data]
    features = np.array(features).astype(np.float)
    #features = features.reshape(1, -1)

print("labels: " + str(labels))
print("features: " + str(features))
print("Shape labels: " + str(labels.shape))
print("Shape features: " + str(features.shape))

# Organize our data
label_names = ['score']
labels #= data['target']
feature_names = ['damageSource', 'nrDamages', 'nr_images']
features #= data['data']

# Look at our data
print(label_names)
print('Class label = ', labels[0])
print(feature_names)
print(features[0])

# Split our data
train, test, train_labels, test_labels = train_test_split(features,
                                                          labels,
                                                          test_size=0.33,
                                                          random_state=42)

# Initialize our classifier
gnb = GaussianNB()

# Train our classifier
model = gnb.fit(train, train_labels)

# Make predictions
preds = gnb.predict(test)
print(preds)

# Evaluate accuracy
print(accuracy_score(test_labels, preds))