import React from 'react'
import { MDBCard, MDBInput, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'
import Switch from '@material-ui/core/Switch'
import FormGroup from '@material-ui/core/FormGroup'
import FormControlLabel from '@material-ui/core/FormControlLabel'


export default function Notification({signupDetails}) {
  const [emailChecked, setEmailChecked] = React.useState(false)
  const [smsChecked, setSmsChecked] = React.useState(false)

  const toggleEmailChecked = () => {
    setEmailChecked((prev) => !prev)
  }

  const toggleSmsChecked = () => {
    setSmsChecked((prev) => !prev)
  }


  return (
    <div>
      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard className="text-left">
            <MDBCardBody>
              <MDBCardTitle>Notification</MDBCardTitle>
              <MDBCardText>

                <FormControlLabel
                  control={<Switch checked={emailChecked} onChange={toggleEmailChecked} />}
                  label="Notification via Email"
                />
                <FormControlLabel
                  control={<Switch checked={smsChecked} onChange={toggleSmsChecked} />}
                  label="Notification via SMS"
                />

                { emailChecked && <MDBInput focused label="Email Address" icon="envelope" validate error="wrong" success="right" /> }
                { smsChecked && <MDBInput focused label="SMS Phone number" icon="phone" validate error="wrong" success="right" /> }

              </MDBCardText>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
        <MDBCol md='4'>
        </MDBCol>
      </MDBRow>
      <br/>
      <br/>
    </div>
  )
}
