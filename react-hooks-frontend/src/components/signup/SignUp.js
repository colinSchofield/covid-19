import React from 'react'
import { makeStyles } from '@material-ui/core/styles'
import Stepper from '@material-ui/core/Stepper'
import Step from '@material-ui/core/Step'
import StepLabel from '@material-ui/core/StepLabel'
import Button from '@material-ui/core/Button'
import Welcome from './Welcome'
import Details from './Details'
import Regions from './Regions'
import Notification from './Notification'
import Confirm from './Confirm'

const WELCOME_PAGE = 0
const DETAILS_PAGE = 1
const REGIONS_PAGE = 2
const NOTIFICATION_PAGE = 3
const CONFIRM_PAGE = 4

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
  },
  backButton: {
    marginRight: theme.spacing(1),
  },
}))

function getSteps() {
  return ['Welcome', 'Details', 'Regions', 'Notification', 'Confirm']
}

export default function SignUp() {
  const details = React.useRef()
  const detailsRef = React.useRef()
  const notificationRef = React.useRef()
  const regionsRef = React.useRef()
  const [activeStep, setActiveStep] = React.useState(0)
  const classes = useStyles()
  const steps = getSteps()

  const handleNext = () => {
    doNextAction(activeStep)
  }

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1)
  }

  function doNextAction(step) {
    switch (step) {
      case WELCOME_PAGE:
        setActiveStep((prevActiveStep) => prevActiveStep + 1)
        break
      case DETAILS_PAGE:
        detailsRef.current.click()
        break
      case REGIONS_PAGE:
        regionsRef.current.click()
        break
      case NOTIFICATION_PAGE:
        notificationRef.current.click()
        break
      case CONFIRM_PAGE:
        setActiveStep((prevActiveStep) => prevActiveStep + 1)
        break
      default:
        throw new Error("Unknown Case")
    }
  }

  function getStepContent(step) {
    switch (step) {
      case WELCOME_PAGE:
        return <Welcome signupDetails={details} setActiveStep={setActiveStep} />
      case DETAILS_PAGE:
        return <Details validateRef={detailsRef} signupDetails={details} setActiveStep={setActiveStep} />
      case REGIONS_PAGE:
        return <Regions validateRef={regionsRef} signupDetails={details} setActiveStep={setActiveStep} />
      case NOTIFICATION_PAGE:
        return <Notification validateRef={notificationRef} signupDetails={details} setActiveStep={setActiveStep} />
      case CONFIRM_PAGE:
        return <Confirm signupDetails={details} />
    }
}

  return (
    <div className={classes.root}>
      <Stepper activeStep={activeStep} alternativeLabel>
        {steps.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>
      <div>

        { getStepContent(activeStep) }

        { activeStep === steps.length ? (
          <div>
        { /* TODO Add the Final page in here */}
          </div>
        ) : (
          <div>
            <div>
              <Button
                disabled={activeStep === 0}
                onClick={handleBack}
                className={classes.backButton}
              >
                Back
              </Button>
              <Button variant="contained" color="primary" onClick={handleNext}>
                {activeStep === steps.length - 1 ? 'Finish' : 'Next'}
              </Button>
            </div>
          </div>
        )}
      </div>
    </div>
  )
}
