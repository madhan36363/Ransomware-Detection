# 🔐 Ransomware Detection Android App

An Android-based application to detect and classify potentially malicious apps (especially ransomware) installed on a user's device. It helps raise awareness of apps with suspicious permissions and behaviors.

---

## 🚀 Features

- 📱 Lists all installed apps
- 🔍 Scans apps based on dangerous permissions
- 🛡️ Classifies apps as:
  - ✅ Safe
  - ⚠️ Moderate
  - ❌ Malicious
- 🧠 Simple algorithm-based detection logic
- 🧾 App details and risk levels shown in UI
- 🌙 Dark mode compatible UI (optional)
- 📦 Lightweight APK and fast performance

---

## 🧰 Tech Stack

* **Kotlin** – Primary Language
* **Android Jetpack (ViewModel, LiveData, Room)**
* **Room Database** – For storing classification records
* **RecyclerView & ViewPager2** – UI components
* **Material Design Components** – Clean modern UI
* **Gradle Kotlin DSL** – `build.gradle.kts`

---

## 📦 Installation

### Prerequisites

* Android Studio Flamingo or later
* Android SDK 33+
* Gradle 8.x
* Kotlin 1.9+

### Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/madhan36363/Ransomware-Detection.git
   cd Ransomware-Detection
   ```

2. **Open in Android Studio**

   * File > Open > Select the project folder

3. **Build & Run**

   * Connect your Android device or start an emulator
   * Click `Run` ▶️ or use `Shift + F10`

---

## 🔍 How It Works

This app detects ransomware-like behavior using the following approach:

* Analyzes **permissions** used by each installed app
* Flags apps that request:

  * `SYSTEM_ALERT_WINDOW`
  * `PACKAGE_USAGE_STATS`
  * `WRITE_EXTERNAL_STORAGE`
  * `REQUEST_INSTALL_PACKAGES`
* Categorizes apps based on total risky permissions:

  * 0–1 risky → ✅ Safe
  * 2–3 risky → ⚠️ Moderate
  * 4+ risky → ❌ Malicious

---

## 📱 Permissions Used

| Permission            | Purpose                                                        |
| --------------------- | -------------------------------------------------------------- |
| `QUERY_ALL_PACKAGES`  | Get the list of all installed apps                             |
| `PACKAGE_USAGE_STATS` | Monitor usage (if future version includes real-time detection) |
| `INTERNET`            | Reserved for future cloud sync (currently unused)              |

---

## 🛠 Folder Structure

```bash
Ransomware-Detection/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/ransomedetector/
│   │       └── res/
│   ├── build.gradle.kts
├── gradle/
├── gradlew
├── settings.gradle.kts
└── README.md
```

---

## 🔄 Future Scope

* 🤖 Integrate AI/ML-based ransomware detection
* ☁️ Add cloud support for signature updates
* 📊 Visual threat analytics & charts
* 🧪 Real-time app behavior monitoring

---

## 🤝 Contributing

Contributions are welcome!
If you'd like to improve detection logic, UI, or features:

1. Fork the project
2. Create your branch (`git checkout -b feature-name`)
3. Commit your changes (`git commit -m 'add feature'`)
4. Push to your branch (`git push origin feature-name`)
5. Open a Pull Request

---

## 📄 License

This project is open-sourced under the [MIT License](LICENSE).

---

## 👤 Author

**Madhan**
GitHub: [@madhan36363](https://github.com/madhan36363)

---

## ⭐ Show Support

If you like this project:

* Give it a ⭐ on GitHub
* Share it with others

Thank you! 🙌