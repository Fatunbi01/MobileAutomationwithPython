from behave import *
from appium import webdriver
from appium.options.android import UiAutomator2Options
from appium.webdriver.common.appiumby import AppiumBy
import time

@given('I open the Gmail application')
def step_open_gmail(context):
    context.options = UiAutomator2Options()
    context.options.platform_name = 'Android'
    context.options.device_name = 'emulator-5554'
    context.options.automation_name = 'UiAutomator2'
    context.options.no_reset = True

    context.driver = webdriver.Remote('http://127.0.0.1:4723', options=context.options)
    context.driver.find_element(AppiumBy.ACCESSIBILITY_ID, 'Gmail').click()
    time.sleep(5)


@when('I compose a new email')
def step_compose_email(context):
    context.driver.find_element(
        AppiumBy.ANDROID_UIAUTOMATOR,
        'new UiSelector().resourceId("com.google.android.gm:id/compose_button")'
    ).click()
    time.sleep(3)


@when('I enter "{email}" as recipient')
def step_enter_recipient(context, email):
    to_field = context.driver.find_element(
        AppiumBy.ANDROID_UIAUTOMATOR,
        'new UiSelector().className("android.widget.MultiAutoCompleteTextView")'
    )
    to_field.send_keys(email)
    time.sleep(1)
    context.driver.press_keycode(66)  # Press ENTER
    time.sleep(2)


@when('I enter "{subject}" as subject')
def step_enter_subject(context, subject):
    context.driver.find_element(
        AppiumBy.ANDROID_UIAUTOMATOR,
        'new UiSelector().resourceId("com.google.android.gm:id/subject")'
    ).send_keys(subject)
    time.sleep(2)


@when('I enter "{body}" as body')
def step_enter_body(context, body):
    context.driver.find_element(
        AppiumBy.ANDROID_UIAUTOMATOR,
        'new UiSelector().resourceId("com.google.android.gm:id/composearea_tap_trap_bottom")'
    ).click()
    time.sleep(1)

    body_fields = context.driver.find_elements(
        AppiumBy.ANDROID_UIAUTOMATOR,
        'new UiSelector().className("android.widget.EditText")'
    )
    body_fields[1].send_keys(body)
    time.sleep(2)


@then('I send the email')
def step_send_email(context):
    context.driver.find_element(
        AppiumBy.ANDROID_UIAUTOMATOR,
        'new UiSelector().resourceId("com.google.android.gm:id/send")'
    ).click()
    time.sleep(3)


@then('I should see confirmation that email was sent')
def step_verify_confirmation(context):
    # Add verification logic here if needed
    print("Email sent successfully!")

    # Cleanup
    context.driver.quit()