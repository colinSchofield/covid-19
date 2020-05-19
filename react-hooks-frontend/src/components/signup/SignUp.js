import React from 'react'
import { makeStyles } from '@material-ui/core/styles'
import Stepper from '@material-ui/core/Stepper'
import Step from '@material-ui/core/Step'
import StepLabel from '@material-ui/core/StepLabel'
import Button from '@material-ui/core/Button'
import Welcome from './Welcome'
import Details from './Details'
import Regions from './Regions'
import CheckboxListSecondary from './CheckboxListSecondary'


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
  const [activeStep, setActiveStep] = React.useState(0)
  const classes = useStyles()
  const steps = getSteps()

  const handleNext = () => {
    setActiveStep((prevActiveStep) => prevActiveStep + 1)
  }

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1)
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

        { activeStep === WELCOME_PAGE && <Welcome signupDetails={details} /> }
        { activeStep === DETAILS_PAGE && <Details signupDetails={details} /> }
        { activeStep === REGIONS_PAGE && <CheckboxListSecondary signupDetails={details} /> }
        { activeStep === NOTIFICATION_PAGE && <Welcome signupDetails={details} /> }
        { activeStep === CONFIRM_PAGE && <Welcome signupDetails={details} /> }

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
