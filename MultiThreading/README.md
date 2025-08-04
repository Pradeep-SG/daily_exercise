# 🧠 Java Concurrency – Day 1

## ✅ Thread Lifecycle

**States of a Thread:**
1. **NEW**  
   - Thread is created using `new Thread()`
   - Has not started yet

2. **RUNNABLE**  
   - `.start()` is called
   - Thread is ready but waiting for CPU scheduling

3. **RUNNING**  
   - Thread is actually executing

4. **BLOCKED**  
   - Waiting to acquire a lock on a monitor (e.g., synchronized block)

5. **WAITING**  
   - Waiting indefinitely for another thread to signal (e.g., `join()`, `wait()`)

6. **TIMED_WAITING**  
   - Waiting for a fixed amount of time (e.g., `sleep(ms)`, `join(ms)`)

7. **TERMINATED**  
   - Thread completes execution or terminates due to exception

---

## ✅ `.start()` vs `.run()`

| Method     | Behavior |
|------------|----------|
| `run()`    | Executes like a normal method in the same thread |
| `start()`  | Starts a **new thread** and invokes the `run()` method in that thread |

> ⚠️ Calling `.start()` twice on the same thread throws `IllegalThreadStateException`.

---

## ✅ Thread Creation

### 1. Extending `Thread`
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
```

### 2. Implementing `Runnable` (Preferred)
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Task running");
    }
}
```

- Use `Runnable` with `ExecutorService` for better thread management and loose coupling.

---

## ✅ Runnable vs Callable

| Feature         | `Runnable`                  | `Callable<T>`                    |
|------------------|-----------------------------|----------------------------------|
| Return value     | No                          | Yes (`Future<T>`)                |
| Can throw checked exception | No               | Yes                              |

---

## ✅ Why Avoid Creating Too Many Threads Directly?

- Each thread consumes memory (stack space)
- CPU overhead due to excessive context switching
- Puts pressure on Garbage Collector
- Makes debugging harder
- Prefer using `ExecutorService`

---

## ✅ Common Utility Methods

- `Thread.sleep(ms)` → Pauses thread for given time (`TIMED_WAITING` state)
- `Thread.join()` → Waits for another thread to die
- `thread.setName("CustomThreadName")` → Sets thread name
- `thread.setPriority(int)` → Sets priority (OS dependent)

---

## ✅ Key Interview Notes

- Use `.start()` for actual concurrency
- Never call `.start()` twice on the same thread
- Prefer `Runnable` or `Callable` over extending `Thread`
- Thread pool via `Executors.newFixedThreadPool(n)` is best for large tasks
