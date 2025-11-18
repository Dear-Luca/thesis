
input_data = { 
    "key1": 10, 
    "key2": "value", 
    "key3": { 
        "key4": "value", 
        "key5": 10 
    }, 
    "key6": [1, 2, 3], 
    "key7": [ 
        { 
            "key8": 10, 
            "key9": "value" 
        }, 
        { 
            "key10": 20, 
            "key11": [ 
        { 
            "key8": 10, 
            "key9": "value" 
        }, 
        { 
            "key10": 20, 
            "key11": "value2" 
        } 
    ] 
        } 
    ] 
} 

def string_counter(data) -> int:
    count = 0
    if isinstance(data, dict):
        for key, val in data.items():
            count += string_counter(val)

    elif isinstance(data, list):
        for item in data:
            count += string_counter(item)
    elif isinstance(data, str):
        count += 1

    return count
'''
output -> numbers of strings inside input

idea 1:
    recursive function
'''

'''

'''







print(string_counter(input_data))
