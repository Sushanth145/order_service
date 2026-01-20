import requests
import threading
import time
import random

URL = "http://localhost:8080/order"
TOTAL_USERS = 100
MAX_DELAY = 0.5  # seconds (human think time)


def customer_behavior(customer_id):
    time.sleep(random.uniform(0, MAX_DELAY))  # user think time
    try:
        response = requests.post(URL)
        print(
            f"Customer {customer_id} -> "
            f"Status: {response.status_code}"
        )
    except Exception as e:
        print(f"Customer {customer_id} -> Error: {e}")


threads = []

start_time = time.time()

for i in range(TOTAL_USERS):
    t = threading.Thread(target=customer_behavior, args=(i + 1,))
    t.start()
    threads.append(t)

    time.sleep(0.05)  # gradual ramp-up (50ms)

for t in threads:
    t.join()

end_time = time.time()

print(f"\nCompleted {TOTAL_USERS} customers in {end_time - start_time:.2f} seconds")
