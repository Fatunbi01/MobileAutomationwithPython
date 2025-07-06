from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
import time


def send_gmail():
    # Set up connection to Appium server
    options = UiAutomator2Options()
    options.platform_name = 'Android'
    options.device_name = 'emulator-5554'
    options.automation_name = 'UiAutomator2'
    options.no_reset = True

    # Connect to the device
    driver = webdriver.Remote('http://127.0.0.1:4723', options=options)

    try:
        # Step 1: Open Gmail from home screen
        print("Opening Gmail app...")
        gmail_icon = driver.find_element(AppiumBy.ACCESSIBILITY_ID, 'Gmail')
        gmail_icon.click()
        time.sleep(5)  # Longer wait for app to fully load

        # Step 2: Click compose button
        print("Clicking compose button...")
        compose_button = driver.find_element(
            AppiumBy.ANDROID_UIAUTOMATOR,
            'new UiSelector().resourceId("com.google.android.gm:id/compose_button")'
        )
        compose_button.click()
        time.sleep(3)

        print("Adding recipient...")
        to_field = driver.find_element(
            AppiumBy.ANDROID_UIAUTOMATOR,
            'new UiSelector().className("android.widget.MultiAutoCompleteTextView")'
        )

        # Type email instantly in one go
        to_field.send_keys("yfatunbi@gmail.com")
        time.sleep(1)  # Short wait before pressing ENTER

        # Press ENTER to confirm the email address
        driver.press_keycode(66)
        print("✅ Email address confirmed in To field")
        time.sleep(2)

        # # Step 3: Type and confirm recipient email (FIXED SECTION)
        # print("Adding recipient...")
        # to_field = driver.find_element(
        #     AppiumBy.ANDROID_UIAUTOMATOR,
        #     'new UiSelector().className("android.widget.MultiAutoCompleteTextView")'
        # )
        #
        # # Type email slowly with pauses between characters
        # for char in "yfatunbi@gmail.com":
        #     to_field.send_keys(char)
        #     time.sleep(0.2)
        #
        # time.sleep(3)  # Crucial wait for suggestions to appear
        #
        # # Press ENTER to confirm the email address
        # driver.press_keycode(66)  # 66 is the keycode for ENTER
        # print("✅ Email address confirmed in To field")
        # time.sleep(2)

        # Step 4: Add email subject
        print("Adding subject...")
        subject_field = driver.find_element(
            AppiumBy.ANDROID_UIAUTOMATOR,
            'new UiSelector().resourceId("com.google.android.gm:id/subject")'
        )
        subject_field.send_keys("Gmail Test")
        time.sleep(2)

        # Step 5: Activate body field
        print("Preparing to type body...")
        body_trap = driver.find_element(
            AppiumBy.ANDROID_UIAUTOMATOR,
            'new UiSelector().resourceId("com.google.android.gm:id/composearea_tap_trap_bottom")'
        )
        body_trap.click()
        time.sleep(1)

        # Step 6: Type email body
        print("Typing message...")
        body_fields = driver.find_elements(
            AppiumBy.ANDROID_UIAUTOMATOR,
            'new UiSelector().className("android.widget.EditText")'
        )
        body_fields[1].send_keys("This is an automated test email")
        time.sleep(2)

        # Step 7: Send the email
        print("Sending email...")
        send_button = driver.find_element(
            AppiumBy.ANDROID_UIAUTOMATOR,
            'new UiSelector().resourceId("com.google.android.gm:id/send")'
        )
        send_button.click()
        print("✅ Email sent successfully to yfatunbi@gmail.com!")
        time.sleep(3)

    finally:
        # Close the app
        driver.quit()
        print("Test completed")


# Run the test
if __name__ == "__main__":
    send_gmail()
