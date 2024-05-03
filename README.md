# TaskMaster

# Task Master

Task Master is a simple yet powerful task management application developed for Android. It allows users to create, update, delete, and filter tasks by status (e.g., "To Do," "In Progress," "Done"). Designed to help individuals manage their daily tasks efficiently, the app offers a user-friendly interface and robust functionality.

## Features

- **Create Tasks**: Users can add new tasks with titles, descriptions, and status.
- **Read/View Tasks**: Users can view the details of existing tasks, making it easy to keep track of progress and updates.
- **Update Tasks**: Existing tasks can be modified, allowing users to update task details as progress is made.
- **Delete Tasks**: Users can delete tasks they no longer need, helping keep the task list fresh and relevant.
- **Filter Tasks**: Tasks can be filtered by their status (e.g., "To Do," "In Progress," "Done") for easier management and organization.


## Screenshots

![Screenshot_20240503-093425](https://github.com/Xdiad47/TaskMaster/assets/52922020/aa7996d8-a24f-4f20-a1a7-01c73d60aedf)


![Screenshot_20240503-093419](https://github.com/Xdiad47/TaskMaster/assets/52922020/1ce0ec3f-c089-4212-ab4a-9317adcc984b)


![Screenshot_20240503-093410](https://github.com/Xdiad47/TaskMaster/assets/52922020/10e6af57-1c23-4a58-903b-67fdb74b12da)


## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

- Android Studio
- SDK version: Android API 21 or higher

### Installation

1. **Clone the repository:**

   ```bash
   git clone [https://github.com/yourusername/taskmaster.git](https://github.com/Xdiad47/TaskMaster.git)

2. **Open Android Studio**:
    - Launch Android Studio.
    - On the welcome screen, select **"Open an existing Android Studio project"**. If you have another project open, go to **File > Open...**.

3. **Select the Project**:
    - Navigate to the directory where you cloned the repository.
    - Select the project folder and click **"OK"** to open the project in Android Studio.

## Running the Project

Once you have the project open in Android Studio, you can run it on an Android device or emulator:

1. **Connect an Android Device or Setup an Emulator**:
    - To run the project on a physical device, connect it to your computer via USB. Make sure [USB debugging](https://developer.android.com/studio/debug/dev-options) is enabled on your device.
    - To run the project on an emulator, ensure you have an AVD (Android Virtual Device) set up. You can set up a new AVD in Android Studio by navigating to **Tools > AVD Manager** and following the prompts to create a new virtual device.

2. **Run the Project**:
    - Select the 'app' configuration in the toolbar near the top of Android Studio.
    - Press **Shift+F10** or click the green play button on the toolbar to build and run the project.

## Troubleshooting

If you encounter any issues with building or running the project, check the following:

- Ensure that Android Studio is updated to the latest version.
- Verify that the Android SDK tools are properly installed and updated.
- Confirm that your device or emulator has the minimum required API level installed.

# Built With

This section lists the major frameworks and technologies used in the development of this project.

- **[Android Studio](https://developer.android.com/studio)** - The integrated development environment (IDE) used for Android app development.
- **[Room](https://developer.android.com/topic/libraries/architecture/room)** - Persistence library that provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
- **[LiveData](https://developer.android.com/topic/libraries/architecture/livedata)** - Data objects that notify views when the underlying database changes, ensuring your UI matches your data state.
- **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)** - Designed to store and manage UI-related data in a lifecycle-conscious way, allowing data to survive configuration changes such as screen rotations.

# Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

1. **Fork the Project**:
    - Start by forking the project repository. This is done by clicking the 'Fork' button at the top of the repository page on GitHub.

2. **Create your Feature Branch**:
    - Navigate to your forked repository. Open your terminal and execute the following command:
      ```bash
      git checkout -b feature/AmazingFeature
      ```

3. **Commit your Changes**:
    - After you have made your changes, commit them to your branch:
      ```bash
      git commit -m 'Add some AmazingFeature'
      ```

4. **Push to the Branch**:
    - Push your changes to your GitHub repository:
      ```bash
      git push origin feature/AmazingFeature
      ```

5. **Open a Pull Request**:
    - Go to the original project repository and click the 'Compare & pull request' button next to your branch. Review the changes and submit the pull request.

By following these steps, you can contribute to this project and help make it better. Your changes will be reviewed as soon as possible. Thank you for your contribution!

